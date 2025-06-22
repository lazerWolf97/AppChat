package umu.tds.AppChat.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.Contacto;
import umu.tds.AppChat.dominio.ContactoIndividual;
import umu.tds.AppChat.dominio.Grupo;
import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.service.GrupoService;
import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.AppChat.vista.MensajeGrupoView;
import umu.tds.AppChat.vista.observer.ChatListener;
import umu.tds.AppChat.vista.observer.GrupoListener;
import umu.tds.AppChat.vista.observer.MensajeEvent;

@Component
public class MensajeGrupoController {

	private final UsuarioService uService;
	private final MensajeService mService;
	private final GrupoService gService;
	
	private Grupo grupo;
	
	private List<GrupoListener> listeners = new LinkedList<GrupoListener>();
	
	public MensajeGrupoController(UsuarioService uService, MensajeService mService,
			GrupoService gService) {
		this.uService = uService;
		this.mService = mService;
		this.gService = gService;
	}
	
	public void initialize() {
		MensajeGrupoView view = new MensajeGrupoView(this);
		view.showWindow();
	}
	
	public void addListener(GrupoListener listener) {
		listeners.add(listener);
	}
	
	public void setGrupo(Grupo g) {
		this.grupo = g;
	}
	
	public void enviarMensaje(String texto) {
		for(ContactoIndividual ci : grupo.getContactos()) {
			Mensaje m = new Mensaje(texto, LocalDate.now(), LocalTime.now(), 
					CurrentSession.getUsuarioActual(), ci.getUsuario());
			mService.add(m);
			
		}
		mensajeEnviado(texto, LocalDateTime.now());
		
	}
	
	public String getNombreGrupo() {
		return grupo.getNombre();
	}
	
	private void mensajeEnviado(String texto, LocalDateTime fecha) {
		MensajeEvent e = new MensajeEvent(this, fecha, texto, CurrentSession.getIDActual());
		listeners.forEach(l -> l.enviarMensajeGrupo(e));
	}
	
}
