package umu.tds.AppChat.controller;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import umu.tds.AppChat.service.*;

@Component
public class AppController {

    private final UsuarioService uService;
    private final MensajeService mService;

    @Autowired
    public AppController(UsuarioService uService, MensajeService mService) {
        this.uService = uService;
        this.mService = mService;
    }

    public void mostrarVentanaPrincipal() {
        ChatController chatController = new ChatController(uService, mService, this);
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
    	SearchController searchController = new SearchController(mService, this);
    	searchController.initialize();
    }
}
