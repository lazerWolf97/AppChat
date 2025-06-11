package umu.tds.AppChat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class UsuarioDTO {
	
	@NotNull
	@JsonProperty("numTLF")
	private String numTLF;
	
	@JsonProperty("nombre")
	private String nombre;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("fnacimiento")
	private String fnacimiento;
	
	@JsonProperty("password")
	private String password;
	
	public UsuarioDTO() {
		numTLF = null;
		nombre = null;
		email = null;
		fnacimiento = null;
		password = null;
	}
	
	public UsuarioDTO(String numTLF, String nombre, String email, String fNacimiento, String password) {
		this.numTLF = numTLF;
		this.nombre = nombre;
		this.email = email;
		this.fnacimiento = fNacimiento;
		this.password = password;
	}
	
	public String getNumTLF() {
		return numTLF;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFnacimiento() {
		return fnacimiento;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setNumTLF(String numTLF) {
		this.numTLF = numTLF;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setFnacimiento(String fNacimiento) {
		this.fnacimiento = fNacimiento;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
