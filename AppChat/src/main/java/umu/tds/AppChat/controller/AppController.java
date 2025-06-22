package umu.tds.AppChat.controller;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.Grupo;
import umu.tds.AppChat.service.*;
import umu.tds.AppChat.vista.observer.GrupoListener;
import umu.tds.AppChat.vista.observer.PerfilListener;

@Component
public class AppController {

    private final UsuarioService uService;
    private final MensajeService mService;
    private final GrupoService gService;
    private final ContactoIndividualService cService;

    @Autowired
    public AppController(UsuarioService uService, MensajeService mService,
    		GrupoService gService, ContactoIndividualService cService) {
        this.uService = uService;
        this.mService = mService;
        this.gService = gService;
        this.cService = cService;
    }

    public void mostrarVentanaPrincipal() {
        ChatController chatController = 
        		new ChatController(uService, mService, gService, cService, this);
        chatController.initialize();
    }

    public void mostrarLogin() {
        LoginController loginController = new LoginController(uService, this);
        loginController.initialize();
    }
    
    public void mostrarSignup() {
    	SignupController signupController = new SignupController(uService, this);
    	signupController.initialize();
    }
    
    public void mostrarSearch() {
    	SearchController searchController = new SearchController(uService, mService, cService, this);
    	searchController.initialize();
    }
    
    public void mostrarCrearGrupo() {
    	CrearGrupoController grupoController = new CrearGrupoController(gService, uService, this);
    	grupoController.initialize();
    }
    
    public void mostrarCrearContacto() {
    	CrearContactoController contactoController = 
    			new CrearContactoController(cService, uService, this);
    	contactoController.initialize();
    }
    
    public void mostrarPerfil(PerfilListener listener) {
    	PerfilController perfilController = new PerfilController(uService, this);
    	perfilController.setListener(listener);
    	perfilController.initialize();
    }
    
    public void mostrarMensajeGrupo(Grupo g, GrupoListener gl) {
    	MensajeGrupoController mgController = new MensajeGrupoController(uService, mService, gService);
    	mgController.setGrupo(g);
    	mgController.addListener(gl);
    	mgController.initialize();
    }
}
