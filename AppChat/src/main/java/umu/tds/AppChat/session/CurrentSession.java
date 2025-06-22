package umu.tds.AppChat.session;

import umu.tds.AppChat.dominio.Usuario;

public class CurrentSession {
	
	private static Usuario usuarioActual;
	
	private CurrentSession() {
		
	}
	
	public static Usuario getUsuarioActual() {
		return usuarioActual;
	}
	
	public static void iniciarSesion(Usuario u) {
		usuarioActual = u;
	}
	
	public static void cerrarSesion() {
		usuarioActual = null;
	}
	
	public static String getIDActual() {
		return usuarioActual.getNumTLF();
	}
	
}
