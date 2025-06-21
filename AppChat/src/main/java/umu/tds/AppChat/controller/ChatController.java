package umu.tds.AppChat.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.ContactoIndividual;
import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.dominio.Usuario;
import umu.tds.AppChat.service.ContactoIndividualService;
import umu.tds.AppChat.service.GrupoService;
import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.AppChat.vista.MainView;

@Component
public class ChatController {

	private final MensajeService mService;
	private final UsuarioService uService;
	private final GrupoService gService;
	private final ContactoIndividualService cService;
	private final AppController controller;
	
	public ChatController(UsuarioService uService, MensajeService mService,
			GrupoService gService, ContactoIndividualService cService ,AppController controller) {
		this.mService = mService;
		this.uService = uService;
		this.gService = gService;
		this.cService = cService;
		this.controller = controller;
	}
	
	public void initialize() {
		MainView view = new MainView(this);
		view.showWindow();
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
	
	public Optional<ContactoIndividual> getContactoIndividual(Usuario u) {
		return CurrentSession.getUsuarioActual().getContactoIndividual(u);
	}
	
	public String getCurrentUsername() {
		return CurrentSession.getUsuarioActual().getNombre();
	}
	
	public String getCurrentNumber() {
		return CurrentSession.getUsuarioActual().getNumTLF();
	}
	
	public void registerMensaje(String texto, String receptor) {
		Mensaje m = new Mensaje(texto, LocalDate.now(), LocalTime.now(),
				CurrentSession.getUsuarioActual(), uService.findByNumTLF(receptor).get());
		mService.add(m);
	}
	
}
