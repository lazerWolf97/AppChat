package umu.tds.AppChat.controller.strategy;

import java.util.List;

import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.exceptions.UserException;

public interface Busqueda {
	
	List<Mensaje> buscarMensaje(String texto, String otroUsuario,
			MensajeService mService, UsuarioService uService) throws UserException;
}
