package umu.tds.AppChat.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.persistence.*;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

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
	@Column(name="nmensajes")
	private long nmensajes;
	@Column(name="fecharegistro")
	private LocalDate fregistro;
	@Column(name="premium")
	private boolean premium;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="contactos")
	private List<Contacto> contactos;
	@OneToMany
	@JoinColumn(name="enviados")
	private List<Mensaje> enviados;
	@OneToMany
	@JoinColumn(name="recibidos")
	private List<Mensaje> recibidos;
	
	@Transient
	private Descuento descuento;
	
	public Usuario(String numTLF, String nombre, String email, String password,
			String fNacimiento) {
		this.numTLF = numTLF;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.fnacimiento = LocalDate.parse(fNacimiento);
		this.fregistro = LocalDate.now();
		this.contactos = new LinkedList<Contacto>();
		this.enviados = new LinkedList<Mensaje>();
		this.recibidos = new LinkedList<Mensaje>();
		this.nmensajes = 0;
		this.premium = false;
	}
	
	public Usuario(String numTLF, String nombre, String email, String password,
			String fNacimiento, String fRegistro) {
		this.numTLF = numTLF;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.fnacimiento = LocalDate.parse(fNacimiento);
		this.fregistro = LocalDate.parse(fRegistro);
		this.contactos = new LinkedList<Contacto>();
		this.enviados = new LinkedList<Mensaje>();
		this.recibidos = new LinkedList<Mensaje>();
		this.nmensajes = 0;
		this.premium = false;
	}
	
	
	public Usuario(String numTLF, String nombre, String email, String password, int dia, int mes, int año,
			LocalDate fRegistro) {
		this.numTLF = numTLF;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.fnacimiento = LocalDate.of(año, mes, dia);
		this.fregistro = fRegistro;
		this.contactos = new LinkedList<Contacto>();
		this.enviados = new LinkedList<Mensaje>();
		this.recibidos = new LinkedList<Mensaje>();
		this.nmensajes = 0;
		this.premium = false;
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
	
	public long getNMensajes() {
		return nmensajes;
	}

	public LocalDate getFnacimiento() {
		return fnacimiento;
	}
	
	public LocalDate getFregistro() {
		return fregistro;
	}
	
	public List<Contacto> getContactos() {
		return contactos;
	}
	
	public boolean isPremium() {
		return premium;
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
	
	public void setFnacimiento(LocalDate fNacimiento) {
		this.fnacimiento = fNacimiento;
	}
	
	public void addContacto(Contacto c) {
		contactos.add(c);
	}
	
	public void addMensajeContador() {
		nmensajes++;
	}
	
	public void setNMensajes(long n) {
		nmensajes = n;
	}
	
	public void setFRegistro(String fRegistro) {
		this.fregistro = LocalDate.parse(fRegistro);
	}
	
	public void setFRegistro(LocalDate fRegistro) {
		this.fregistro = fRegistro;
	}
	
	public long getYearsOld() {
		return ChronoUnit.YEARS.between(fregistro, LocalDate.now());
	}
	
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	
	public void establecerDescuento(String tipo) {
		descuento = DescuentoFactory.getDescuento(tipo);
	}
	
	public double calcularDescuento() {
		return descuento.calcularTotal(this);
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
	
	public boolean compararTLF(Usuario u) {
		return numTLF.compareTo(u.getNumTLF()) == 0;
	}
	
	public boolean compararTLF(String ntlf) {
		return numTLF.compareTo(ntlf) == 0;
	}
	
	public ContactoIndividual crearContacto(String nombre, Usuario contacto) {
		Optional<Contacto> copt = contactos.stream()
				.filter(c -> c instanceof ContactoIndividual ci 
						&& ci.getNumTLF().compareTo(contacto.getNumTLF()) == 0)
				.findFirst();
		
		if(copt.isPresent()) {
			ContactoIndividual ci = (ContactoIndividual) copt.get();
			ci.setNombre(nombre);
			return ci;
		}
		else {
			ContactoIndividual ci = new ContactoIndividual(nombre, contacto);
			contactos.add(ci);
			return ci;
		}
	}
	
	public Grupo crearGrupo(String nombre, List<ContactoIndividual> contactos) {
		Grupo g = new Grupo(nombre, contactos);
		this.contactos.add(g);
		return g;
	}
	
	public void eliminarContactos(Contacto c) {
		contactos.remove(c);
	}
	
}
