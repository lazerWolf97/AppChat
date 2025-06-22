package umu.tds.AppChat.controller.strategy;

import java.util.List;

import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.exceptions.UserException;
import umu.tds.exceptions.UserException.UserErrorType;

public class BusquedaNumero implements Busqueda {

	@Override
	public List<Mensaje> buscarMensaje(String texto, String otroUsuario,
			MensajeService mService, UsuarioService uService) throws UserException {
		if(uService.findByNumTLF(otroUsuario).isEmpty()) {
			throw new UserException("Usuario no encontrado.", UserErrorType.USERNOTFOUND);
		}
		return mService.findByUserAndText(otroUsuario, texto);
	}

}
