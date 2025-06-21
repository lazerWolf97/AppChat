package umu.tds.AppChat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.Contacto;
import umu.tds.AppChat.dominio.ContactoIndividual;
import umu.tds.AppChat.dominio.Grupo;
import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.dominio.Usuario;
import umu.tds.AppChat.service.ContactoIndividualService;
import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.AppChat.vista.SearchView;
import umu.tds.exceptions.UserException;
import umu.tds.exceptions.UserException.UserErrorType;

@Component
public class SearchController {

	private final UsuarioService uService;
	private final MensajeService mService;
	private final ContactoIndividualService cService;
	private final AppController controller;
	
	public SearchController(UsuarioService uService, MensajeService mService,
			ContactoIndividualService cService, AppController controller) {
		this.uService = uService;
		this.mService = mService;
		this.cService = cService;
		this.controller = controller;
	}
	
	public void initialize() {
		SearchView view = new SearchView(this);
		view.showWindow();
	}
	
	public List<Mensaje> buscarMensajesPorNumero(String texto, String telefono) throws UserException {
		if(uService.findByNumTLF(telefono).isEmpty()) {
			throw new UserException("Usuario no encontrado.", UserErrorType.USERNOTFOUND);
		}
		return mService.findByUserAndText(telefono, texto);
	}
	
	public List<Mensaje> buscarMensajesPorContacto(String texto, String nombre) throws UserException {
		List<Mensaje> lm = new ArrayList<Mensaje>();
		
		List<Contacto> lc = CurrentSession.getUsuarioActual()
				.getContactos().stream()
				.filter(c -> c.getNombre().contains(nombre))
				.toList();
		if(lc.isEmpty()) {
			throw new UserException("Contacto no encontrado.", UserErrorType.USERNOTFOUND);
		}
		
		for(Contacto c : lc) {
			if(c instanceof ContactoIndividual) {
				ContactoIndividual ci = (ContactoIndividual) c;
				lm.addAll(mService.findByUserAndText(ci.getNumTLF(), texto));
			}
			else if(c instanceof Grupo) {
				
			}
		}
		return lm;
	}
	
}
