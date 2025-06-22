package umu.tds.AppChat.dominio;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="GRUPO")
public class Grupo extends Contacto {

	@ManyToMany(fetch = FetchType.EAGER)
	private List<ContactoIndividual> contactos;
	
	public Grupo(String nombre) {
		super(nombre);
		contactos = new LinkedList<ContactoIndividual>();
	}
	
	public Grupo(String nombre, List<ContactoIndividual> lista) {
		super(nombre);
		contactos = lista;
	}
	
	public Grupo() {
		super();
	}
	
	public List<ContactoIndividual> getContactos (){
		return contactos;
	}
	
	public void addContacto(ContactoIndividual c) {
		contactos.add(c);
	}

}
