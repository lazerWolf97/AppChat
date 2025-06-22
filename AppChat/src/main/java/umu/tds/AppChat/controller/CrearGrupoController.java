package umu.tds.AppChat.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.Contacto;
import umu.tds.AppChat.dominio.ContactoIndividual;
import umu.tds.AppChat.dominio.Grupo;
import umu.tds.AppChat.service.GrupoService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.AppChat.vista.GrupoView;

@Component
public class CrearGrupoController {

	private final GrupoService gService;
	private final UsuarioService uService;
	private final AppController controller;
	
	public CrearGrupoController(GrupoService gService, UsuarioService uService,
			AppController controller) {
		this.gService = gService;
		this.uService = uService;
		this.controller = controller;
	}
	
	public void initialize() {
		GrupoView view = new GrupoView(this);
		view.showWindow();
	}
	
	public void mostrarVentanaPrincipal() {
		controller.mostrarVentanaPrincipal();
	}
	
	public List<ContactoIndividual> getContactos() {
		List<Contacto> lc = CurrentSession.getUsuarioActual().getContactos();
		List<ContactoIndividual> lci = new LinkedList<ContactoIndividual>();
		for(Contacto c : lc) {
			if(c instanceof ContactoIndividual) {
				ContactoIndividual ci = (ContactoIndividual) c;
				lci.add(ci);
			}
				
		}
		
		return lci;
	}
	
	public void crearGrupo(List<ContactoIndividual> lista, String nombre) {
		Grupo g = new Grupo(nombre, lista);
		CurrentSession.getUsuarioActual().addContacto(g);
		gService.add(g);
		uService.update(CurrentSession.getUsuarioActual());
	}
	
}
