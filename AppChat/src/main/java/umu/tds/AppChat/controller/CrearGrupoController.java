package umu.tds.AppChat.controller;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.service.GrupoService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.vista.GrupoView;

@Component
public class CrearGrupoController {

	private final GrupoService gService;
	// private final UsuarioService uService;
	private final AppController controller;
	
	public CrearGrupoController(GrupoService gService, AppController controller) {
		this.gService = gService;
		this.controller = controller;
	}
	
	public void initialize() {
		GrupoView view = new GrupoView(this);
		view.showWindow();
	}
	
	public void crearGrupo() {
		
	}
	
}
