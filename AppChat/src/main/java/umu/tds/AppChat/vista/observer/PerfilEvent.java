package umu.tds.AppChat.vista.observer;

import java.util.EventObject;

public class PerfilEvent extends EventObject {

	private static final long serialVersionUID = -1825944098376372029L;
	
	private String nuevoNombre;
	
	public PerfilEvent(Object source, String nombre) {
		super(source);
		nuevoNombre = nombre;
	}
	
	public String getNombre() {
		return nuevoNombre;
	}
	
}
