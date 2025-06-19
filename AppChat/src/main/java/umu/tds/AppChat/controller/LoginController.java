package umu.tds.AppChat.controller;

import java.util.Optional;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.Usuario;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.AppChat.vista.LoginView;
import umu.tds.exceptions.UserException;

@Component
public class LoginController {

	private final UsuarioService uService;
	private final AppController controller;

	public LoginController(UsuarioService uService, AppController controller) {
		this.uService = uService;
		this.controller = controller;
	}
	
	public void initialize() {
		LoginView view = new LoginView(this);
		view.showWindow();
	}
	
	public boolean login(String numTLF, String password) throws UserException {
		Optional<Usuario> u = uService.login(numTLF, password);
		if(u.isPresent()) {
			CurrentSession.iniciarSesion(u.get());
			return true;
		}
		return false;
	}
	
	public void mostrarSignup() {
		controller.mostrarSignup();
	}
	
	public void mostrarVentanaPrincipal() {
		controller.mostrarVentanaPrincipal();
	}
	
	
}
