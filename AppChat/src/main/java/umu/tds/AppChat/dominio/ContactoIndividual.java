package umu.tds.AppChat.dominio;

import javax.persistence.*;

@Entity
@Table (name="CONTACTOINDIVIDUAL")
public class ContactoIndividual extends Contacto {
	
	@OneToOne
	@JoinColumn(name = "numTLF")
	private Usuario usuario;
	
	public ContactoIndividual(String nombre, Usuario u) {
		super(nombre);
		usuario = u;
	}
	
	public ContactoIndividual() {
		super();
	}

	public String getNumTLF() {
		return usuario.getNumTLF();
	}
}
