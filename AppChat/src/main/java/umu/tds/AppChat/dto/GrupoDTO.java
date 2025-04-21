package umu.tds.AppChat.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GrupoDTO extends ContactoDTO {

	@JsonProperty("usuarios")
	private List<String> usuarios;
	
	public GrupoDTO() {
		super();
		usuarios = null;
	}
	
	public GrupoDTO(String id, String nombre, List<String> usuarios) {
		super(id, nombre);
		this.usuarios = usuarios;
	}
	
}
