package umu.tds.AppChat.controller;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.Mensaje;
import umu.tds.AppChat.dominio.Usuario;
import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.AppChat.vista.MainView;

@Component
public class ChatController {

	private final MensajeService mService;
	private final UsuarioService uService;
	private final AppController controller;
	
	public ChatController(UsuarioService uService, MensajeService mService, AppController controller) {
		this.mService = mService;
		this.uService = uService;
		this.controller = controller;
	}
	
	public void initialize() {
		MainView view = new MainView(this);
		view.showWindow();
	}
	
	public void mostrarSearch() {
		controller.mostrarSearch();
	}
	
	// (Emisor|Receptor)(Fecha|Hora):Mensaje
	public String getMensajes() {
		List<Mensaje> lm = mService.findAllByUser(CurrentSession.getUsuarioActual().getNumTLF());
		StringBuilder sb = new StringBuilder();
		lm.stream().forEach(m -> sb.append("(" + m.getEmisor() + "|"
				+ m.getReceptor() + ")(" + m.getFecha()
				+ "|" + m.getHora() + "):" + m.getTexto()));
		return sb.toString();
	}
	
	// (Emisor|Receptor)(Fecha|Hora):Mensaje
	public String getMensajes(String firstID, String secondID) {
		List<Mensaje> lm = mService.findAllByTwoUsers(firstID, secondID);
		StringBuilder sb = new StringBuilder();
		lm.stream().forEach(m -> sb.append("(" + m.getEmisor() + "|"
				+ m.getReceptor() + ")(" + m.getFecha()
				+ "|" + m.getHora() + "):" + m.getTexto()));
		return sb.toString();
	}
	
	// (Emisor|Receptor)(Fecha|Hora):Mensaje
		public List<String> getMensajesCon(String ID) {
			List<Mensaje> lm = mService
					.findAllByTwoUsers(CurrentSession.getUsuarioActual().getNumTLF(), ID);
			List<String> ls = new LinkedList<String>();
			lm.stream().forEach(m -> new String("(" + m.getEmisor() + "|"
					+ m.getReceptor() + ")(" + m.getFecha()
					+ "|" + m.getHora() + "):" + m.getTexto()));
			return ls;
		}
	
	// (Emisor|Receptor)(Fecha|Hora):Mensaje
	public String searchMensajes(String text, String ID, String name) {
		List<Mensaje> lm = mService.findByUserAndText(CurrentSession.getUsuarioActual().getNumTLF(), text);
		StringBuilder sb = new StringBuilder();
		lm.stream().forEach(m -> sb.append("(" + m.getEmisor() + "|"
				+ m.getReceptor() + ")(" + m.getFecha()
				+ "|" + m.getHora() + "):" + m.getTexto()));
		return sb.toString();
	}
	
	public String getCurrentUsername() {
		return CurrentSession.getUsuarioActual().getNombre();
	}
	
	
	
}
