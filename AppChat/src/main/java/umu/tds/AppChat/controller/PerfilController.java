package umu.tds.AppChat.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.AppChat.vista.PerfilVista;
import umu.tds.AppChat.vista.observer.PerfilListener;

@Component
public class PerfilController {

	private final UsuarioService uService;
	
	private PerfilListener listener;
	
	@Autowired
	public PerfilController(UsuarioService uService) {
		this.uService = uService;
		
	}
	
	public void setListener(PerfilListener listener) {
		this.listener = listener;
	}
	
	public void initialize() {
		PerfilVista view = new PerfilVista(this, listener);
		view.showWindow();
	}
	
	public void actualizar(String nombre, String email, LocalDate fechan) {
		if(nombre.length() > 0) {
			CurrentSession.getUsuarioActual().setNombre(nombre);
		}
		if(email.length() > 0) {
			CurrentSession.getUsuarioActual().setEmail(email);
		}
		CurrentSession.getUsuarioActual().setFnacimiento(fechan);
		
		uService.update(CurrentSession.getUsuarioActual());
	}
	
	public double getPrecioPremium() {
		if(CurrentSession.getUsuarioActual().getYearsOld() >= 2) {
			CurrentSession.getUsuarioActual().establecerDescuento("Fecha");
		}
		else {
			CurrentSession.getUsuarioActual().establecerDescuento("Mensajes");
		}
		return CurrentSession.getUsuarioActual().calcularDescuento();
	}
	
	public void hacerPremium() {
		CurrentSession.getUsuarioActual().setPremium(true);
		listener.setPremium();
	}
	
	public boolean comprobarPremium() {
		return CurrentSession.getUsuarioActual().isPremium();
	}
	
}
