package umu.tds.AppChat.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.controller.strategy.Busqueda;
import umu.tds.AppChat.controller.strategy.FactoryBusqueda;
import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.vista.SearchView;
import umu.tds.exceptions.UserException;

@Component
public class SearchController {

	private final UsuarioService uService;
	private final MensajeService mService;
	
	private Busqueda busqueda;
	
	public SearchController(UsuarioService uService, MensajeService mService) {
		this.uService = uService;
		this.mService = mService;
	}
	
	public void initialize() {
		SearchView view = new SearchView(this);
		view.showWindow();
	}
	
	public void setMetodoBusqueda(String tipo) {
		busqueda = FactoryBusqueda.getBusqueda(tipo);
	}
	
	public List<Mensaje> buscarMensajes(String texto, String otroUsuario) throws UserException {
		return busqueda.buscarMensaje(texto, otroUsuario, mService, uService);
	}
	
	/*
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
	}*/
	
}
