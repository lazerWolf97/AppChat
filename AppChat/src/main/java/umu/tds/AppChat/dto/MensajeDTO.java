package umu.tds.AppChat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class MensajeDTO {

	@NotNull
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("texto")
	private String texto;
	
	@JsonProperty("fecha")
	private String fecha;
	
	@JsonProperty("hora")
	private String hora;
	
	@JsonProperty("emisor")
	private UsuarioDTO emisor;
	
	@JsonProperty("receptor")
	private UsuarioDTO receptor;

	public MensajeDTO() {
		this.id = null;
		this.texto = null;
		this.fecha = null;
		this.hora = null;
		this.emisor = null;
		this.receptor = null;
	}
	
	public MensajeDTO(String id, String texto, String fecha, String hora,
			UsuarioDTO emisor, UsuarioDTO receptor) {
		this.id = id;
		this.texto = texto;
		this.fecha = fecha;
		this.hora = hora;
		this.emisor = emisor;
		this.receptor = receptor;
	}

	public String getId() {
		return id;
	}

	public String getTexto() {
		return texto;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}

	public UsuarioDTO getEmisor() {
		return emisor;
	}

	public UsuarioDTO getReceptor() {
		return receptor;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setEmisor(UsuarioDTO emisor) {
		this.emisor = emisor;
	}

	public void setReceptor(UsuarioDTO receptor) {
		this.receptor = receptor;
	}
	
	
	
}
