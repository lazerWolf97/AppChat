package umu.tds.AppChat.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.ContactoIndividual;
import umu.tds.AppChat.dominio.Usuario;
import umu.tds.AppChat.service.ContactoIndividualService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.session.CurrentSession;
import umu.tds.AppChat.vista.CrearContactoView;
import umu.tds.exceptions.UserException;
import umu.tds.exceptions.UserException.UserErrorType;

@Component
public class CrearContactoController {

	private final ContactoIndividualService cService;
	private final UsuarioService uService;
	private final AppController controller;
	
	@Autowired
    public CrearContactoController(ContactoIndividualService cService, 
    		UsuarioService uService, AppController controller) {
        this.cService = cService;
        this.uService = uService;
        this.controller = controller;
    }
	
	public void initialize() {
		CrearContactoView view = new CrearContactoView(this);
		view.showWindow();
	}
	
	public void crearContacto(String nombre, String telefono) {
		Optional<Usuario> u = uService.findByNumTLF(telefono);
		if(u.isEmpty())
			throw new UserException("No existe ningún usuario con ese teléfono.", UserErrorType.USERNOTFOUND);
		
		ContactoIndividual c = CurrentSession.getUsuarioActual().crearContacto(nombre, u.get());
		
		cService.addOrUpdate(c);
		uService.update(CurrentSession.getUsuarioActual());
	}
	
	public void mostrarVentanaPrincipal() {
		controller.mostrarVentanaPrincipal();
	}
}
