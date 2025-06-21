package umu.tds.AppChat.controller;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.Contacto;
import umu.tds.AppChat.dominio.ContactoIndividual;
import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.dominio.Usuario;
import umu.tds.AppChat.service.ContactoIndividualService;
import umu.tds.AppChat.service.GrupoService;
import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.AppChat.vista.MainView;
import umu.tds.AppChat.vista.observer.ChatListener;
import umu.tds.AppChat.vista.observer.MensajeEvent;
import umu.tds.AppChat.vista.observer.PerfilListener;

@Component
public class ChatController {

	private final MensajeService mService;
	private final UsuarioService uService;
	private final GrupoService gService;
	private final ContactoIndividualService cService;
	private final AppController controller;
	
	private PerfilListener listener;
	private List<ChatListener> chatListeners;
	
	public ChatController(UsuarioService uService, MensajeService mService,
			GrupoService gService, ContactoIndividualService cService ,AppController controller) {
		this.mService = mService;
		this.uService = uService;
		this.gService = gService;
		this.cService = cService;
		this.controller = controller;
		this.chatListeners = new LinkedList<ChatListener>();
	}
	
	public void initialize() {
		MainView view = new MainView(this);
		view.showWindow();
	}
	
	public void addChatListener(ChatListener listener) {
		chatListeners.add(listener);
	}
	
	public void mostrarSearch() {
		controller.mostrarSearch();
	}
	
	public void mostrarCrearGrupo() {
		controller.mostrarCrearGrupo();
	}
	
	public void mostrarCrearContacto() {
		controller.mostrarCrearContacto();
	}
	
	public void mostrarPerfil(PerfilListener listener) {
		controller.mostrarPerfil(listener);
	}
	
	public List<Mensaje> getMensajes(){
		return mService.findAllByUser(CurrentSession.getUsuarioActual().getNumTLF());
	}
	
	public List<Mensaje> getMensajesCon(String ID) {
		return mService
				.findAllByTwoUsers(CurrentSession.getUsuarioActual().getNumTLF(), ID);
	}
	
	public List<Mensaje> getUltimosMensajes(String ID) {
		return mService.findLastByUser(ID);
	}
	
	public List<Mensaje> getUltimosMensajes() {
		return mService.findLastByUser(CurrentSession.getUsuarioActual().getNumTLF());
	}
	
	public List<Contacto> getContactos() {
		return CurrentSession.getUsuarioActual().getContactos();
	}
	
	public Optional<ContactoIndividual> getContactoIndividual(Usuario u) {
		return CurrentSession.getUsuarioActual().getContactoIndividual(u);
	}
	
	public String getCurrentUsername() {
		return CurrentSession.getUsuarioActual().getNombre();
	}
	
	public String getCurrentNumber() {
		return CurrentSession.getUsuarioActual().getNumTLF();
	}
	
	public void registerMensaje(String texto, String receptor, LocalDateTime fecha) {
		Mensaje m = new Mensaje(texto, fecha.toLocalDate(), fecha.toLocalTime(),
				CurrentSession.getUsuarioActual(), uService.findByNumTLF(receptor).get());
		mService.add(m);
		mensajeEnviado(texto, fecha);
	}
	
	private void mensajeRecibido(String mensaje, LocalDateTime fecha) {
		MensajeEvent e = new MensajeEvent(this, fecha, mensaje);
		chatListeners.forEach(l -> l.recibirMensaje(e));
	}
	
	private void mensajeEnviado(String mensaje, LocalDateTime fecha) {
		MensajeEvent e = new MensajeEvent(this, fecha, mensaje);
		chatListeners.forEach(l -> l.enviarMensaje(e));
	}
	
}
