package umu.tds.AppChat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactoIndividualDTO extends ContactoDTO{

	@JsonProperty("usuario")
	private String usuario;
	
	public ContactoIndividualDTO() {
		super();
		usuario = null;
	}
	
	public ContactoIndividualDTO(String id, String nombre, String usuario) {
		super(id, nombre);
		this.usuario = usuario;
	}
	
}
