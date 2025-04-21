package umu.tds.AppChat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioPostDTO extends UsuarioDTO {
	
	@JsonProperty("password")
	private String password;
	
	public UsuarioPostDTO() {
		super();
		password = null;
	}
	
	public UsuarioPostDTO(String numTLF, String nombre, String email, String password, String fnacimiento) {
		super(numTLF, nombre, email, fnacimiento);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
