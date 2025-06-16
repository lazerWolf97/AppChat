package umu.tds.AppChat.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.vista.SignupView;
import umu.tds.dominio.Usuario;
import umu.tds.exceptions.UserException;
import umu.tds.exceptions.UserException.UserErrorType;

@Component
public class SignupController {
	
	private final UsuarioService uService;
	
	public SignupController(UsuarioService uService) {
		this.uService = uService;
	}
	
	public void initialize() {
		SignupView view = new SignupView(this);
		view.showWindow();
	}
	
	public void register(String numTLF, String nombre, String email, String password, String confirm, LocalDate fechan)
	throws UserException {
		if (password.length() < 8) {
			throw new UserException("Por motivos de seguridad, la contraseña debe de tener al menos 8 caracteres.",
					UserErrorType.PASSWORDCHARACTERS);
		}
		else if(numTLF.length() != 9) {
			throw new UserException("Introduce un número de teléfono válido.", UserErrorType.USERCHARACTERS);
		}
		else if(password.compareTo(confirm) != 0) {
			throw new UserException("Las contraseñas no coinciden.", UserErrorType.PASSWORDNOTMATCH);
		}
		else {
			Usuario u = new Usuario(numTLF, nombre, email, password, fechan.toString());
			uService.registrar(u);
		}
	}
	
	public void mostrarLogin() {
		LoginController lc = new LoginController(uService);
		lc.initialize();
	}

}
