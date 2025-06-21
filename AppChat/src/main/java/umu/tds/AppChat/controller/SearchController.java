package umu.tds.AppChat.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.dominio.Usuario;
import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.vista.SearchView;
import umu.tds.exceptions.UserException;
import umu.tds.exceptions.UserException.UserErrorType;

@Component
public class SearchController {

	private final UsuarioService uService;
	private final MensajeService mService;
	private final AppController controller;
	
	public SearchController(UsuarioService uService,
				MensajeService mService, AppController controller) {
		this.uService = uService;
		this.mService = mService;
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
	
}
