package umu.tds.AppChat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import umu.tds.AppChat.service.*;

@Component
public class AppController {

    private final UsuarioService usuarioService;
    private final MensajeService mensajeService;

    @Autowired
    public AppController(UsuarioService usuarioService, MensajeService mensajeService) {
        this.usuarioService = usuarioService;
        this.mensajeService = mensajeService;
    }

    public void mostrarVentanaPrincipal() {
        ChatController chatController = new ChatController(usuarioService, mensajeService, this);
        chatController.initialize();
    }

    public void mostrarLogin() {
        LoginController loginController = new LoginController(usuarioService, this);
        loginController.initialize();
    }
    
    public void mostrarSignup() {
    	SignupController signupController = new SignupController(usuarioService, this);
    	signupController.initialize();
    }
}
