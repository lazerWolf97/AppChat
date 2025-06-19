package umu.tds.AppChat.dominio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

@Entity
@Table (name="USUARIO")
public class Usuario {

	@Id
	@Column(name="numTLF")
	private String numTLF;
	@Column(name="nombre")
	private String nombre;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="fnacimiento")
	private LocalDate fnacimiento;
	@Column(name="saludo")
	private String saludo;
	
	@OneToMany
	@JoinColumn(name="contactos")
	private List<Contacto> contactos;
	@OneToMany
	@JoinColumn(name="enviados")
	private List<Mensaje> enviados;
	@OneToMany
	@JoinColumn(name="recibidos")
	private List<Mensaje> recibidos;
	
	public Usuario(String numTLF, String nombre, String email, String password, String fNacimiento) {
		this.numTLF = numTLF;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.fnacimiento = LocalDate.parse(fNacimiento);
		this.contactos = new LinkedList<Contacto>();
		this.enviados = new LinkedList<Mensaje>();
		this.recibidos = new LinkedList<Mensaje>();
	}
	
	
	public Usuario(String numTLF, String nombre, String email, String password, int dia, int mes, int año) {
		this.numTLF = numTLF;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.fnacimiento = LocalDate.of(año, mes, dia);
		this.contactos = new LinkedList<Contacto>();
		this.enviados = new LinkedList<Mensaje>();
		this.recibidos = new LinkedList<Mensaje>();
	}
	
	public Usuario() {
		
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

	public String getPassword() {
		return password;
	}

	public LocalDate getFnacimiento() {
		return fnacimiento;
	}
	
	public String getSaludo() {
		return saludo;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFnacimiento(String fNacimiento) {
		this.fnacimiento = LocalDate.parse(fNacimiento);
	}
	
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
	public Optional<ContactoIndividual> getContactoIndividual(Usuario u) {
		String utlf = u.getNumTLF();
		return contactos.stream()
		.filter(c -> c instanceof ContactoIndividual)
		.map(c -> (ContactoIndividual) c)
		.filter(c -> c.getNumTLF().compareTo(utlf) == 0)
		.findFirst();
	}
	
	public List<Mensaje> getChatMensajes(Usuario u) {
		String utlf = u.getNumTLF();
		List<Mensaje> chatMensajes = new LinkedList<Mensaje>();
		
		enviados.stream()
		.filter(m -> m.getReceptor().getNumTLF().compareTo(utlf) == 0)
		.forEach(m -> chatMensajes.add(m));
		recibidos.stream()
		.filter(m -> m.getEmisor().getNumTLF().compareTo(utlf) == 0)
		.forEach(m -> chatMensajes.add(m));
		
		Collections.sort(chatMensajes);
		
		return chatMensajes;
	}

	public boolean comprobarClave(String password) {
		return this.password.compareTo(password) == 0;
	}
}
