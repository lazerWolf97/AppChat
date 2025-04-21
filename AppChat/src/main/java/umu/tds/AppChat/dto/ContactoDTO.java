package umu.tds.AppChat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public abstract class ContactoDTO {
	
	@NotNull
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("nombre")
	private String nombre;
	
	public ContactoDTO() {
		id = null;
		nombre = null;
	}
	
	public ContactoDTO(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
}
