package umu.tds.dominio;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="GRUPO")
public class Grupo extends Contacto {

	@ManyToMany
	private List<ContactoIndividual> contactos;
	
	public Grupo(String nombre) {
		super(nombre);
		contactos = new LinkedList<ContactoIndividual>();
		// TODO Add imagen
	}
	
	public Grupo() {
		super();
	}

}
