package umu.tds.AppChat.vista.observer;

import java.time.LocalDateTime;
import java.util.EventObject;

public class MensajeEvent extends EventObject {
	
	private LocalDateTime fecha;
	private String mensaje;
	
	public MensajeEvent(Object source, LocalDateTime fecha, String mensaje) {
		super(source);
		this.mensaje = mensaje;
		this.fecha = fecha;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
}
