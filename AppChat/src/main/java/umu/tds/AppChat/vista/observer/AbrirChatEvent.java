package umu.tds.AppChat.vista.observer;

import java.util.EventObject;

public class AbrirChatEvent extends EventObject {

	private String numTLF;
	private String nombre;
	
	public AbrirChatEvent(Object source, String numTLF, String nombre) {
		super(source);
		this.numTLF = numTLF;
		this.nombre = nombre;
	}
	
	public String getNumTLF() {
		return numTLF;
	}
	
	public String getNombre() {
		return nombre;
	}
}
