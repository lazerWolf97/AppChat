package umu.tds.AppChat.controller;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.vista.LoginView;
import umu.tds.exceptions.UserException;

@Component
public class LoginController {

	private final UsuarioService uService;
	
	public LoginController(UsuarioService uService) {
		this.uService = uService;
	}
	
	public void initialize() {
		LoginView view = new LoginView(this);
		view.showWindow();
	}
	
	public boolean checkLogin(String numTLF, String password) {
		try {
			uService.login(numTLF, password);
		}
		catch (UserException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	
}
