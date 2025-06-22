package umu.tds.AppChat.controller.strategy;

import java.util.ArrayList;
import java.util.List;

import umu.tds.AppChat.dominio.Contacto;
import umu.tds.AppChat.dominio.ContactoIndividual;
import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.exceptions.UserException;
import umu.tds.exceptions.UserException.UserErrorType;

public class BusquedaContacto implements Busqueda {

	@Override
	public List<Mensaje> buscarMensaje(String texto, String otroUsuario,
			MensajeService mService, UsuarioService uService) throws UserException {
		List<Mensaje> lm = new ArrayList<Mensaje>();
		
		List<Contacto> lc = CurrentSession.getUsuarioActual()
				.getContactos().stream()
				.filter(c -> c.getNombre().contains(otroUsuario))
				.toList();
		if(lc.isEmpty()) {
			throw new UserException("Contacto no encontrado.", UserErrorType.USERNOTFOUND);
		}
		
		for(Contacto c : lc) {
			if(c instanceof ContactoIndividual) {
				ContactoIndividual ci = (ContactoIndividual) c;
				lm.addAll(mService.findByUserAndText(ci.getNumTLF(), texto));
			}
		}
		return lm;
	}

}
