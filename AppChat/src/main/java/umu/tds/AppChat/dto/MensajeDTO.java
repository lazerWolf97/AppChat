package umu.tds.AppChat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import umu.tds.dominio.Usuario;

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
	private Usuario emisor;
	
	@JsonProperty("receptor")
	private Usuario receptor;

	public MensajeDTO() {
		this.id = null;
		this.texto = null;
		this.fecha = null;
		this.hora = null;
		this.emisor = null;
		this.receptor = null;
	}
	
	public MensajeDTO(String id, String texto, String fecha, String hora, Usuario emisor, Usuario receptor) {
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

	public Usuario getEmisor() {
		return emisor;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}
	
	
	
}
