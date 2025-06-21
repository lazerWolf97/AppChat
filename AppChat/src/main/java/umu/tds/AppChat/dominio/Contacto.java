package umu.tds.AppChat.dominio;

import javax.persistence.*;

@Entity
@Table(name="CONTACTO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Contacto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String nombre;
	
	public Contacto(String nombre) {
		this.nombre = nombre;
	}
	
	public Contacto() {
		
	}
	
	public Long getID() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	// Para el ComboBox de la Ventana Principal
	@Override
	public String toString() {
		return nombre;
	}
	
}
