package umu.tds.AppChat.vista.observer;

import java.time.LocalDateTime;
import java.util.EventObject;

public class MensajeEvent extends EventObject {
	
	private LocalDateTime fecha;
	private String mensaje;
	private String emisor;
	
	public MensajeEvent(Object source, LocalDateTime fecha, String mensaje, String emisor) {
		super(source);
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.emisor = emisor;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public String getEmisor() {
		return emisor;
	}
	
}
