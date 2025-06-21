package umu.tds.AppChat.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

@Entity
@Table (name="MENSAJE")
public class Mensaje implements Comparable<Mensaje> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "texto")
	private String texto;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "hora")
	private LocalTime hora;
	
	@ManyToOne
	@JoinColumn(name="emisor")
	private Usuario emisor;
	
	@ManyToOne
	@JoinColumn(name="receptor")
	private Usuario receptor;
	
	public Mensaje(String texto, LocalDate fecha,
			LocalTime hora, Usuario emisor, Usuario receptor) {
		this.texto = texto;
		this.fecha = fecha;
		this.hora = hora;
		this.emisor = emisor;
		this.receptor = receptor;
	}
	
	public Mensaje() {
		
	}

	public long getId() {
		return id;
	}

	public String getTexto() {
		return texto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHora() {
		return hora;
	}
	
	public LocalDateTime getFechaHora() {
		return LocalDateTime.of(fecha, hora);
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}

	@Override
	public int compareTo(Mensaje o) {
		int compfecha = fecha.compareTo(o.getFecha());
		
		if(compfecha != 0) return compfecha;
		else return hora.compareTo(o.getHora());
	}
	
	
	
}
