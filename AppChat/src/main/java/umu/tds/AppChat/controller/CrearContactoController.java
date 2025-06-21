package umu.tds.AppChat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import umu.tds.AppChat.dominio.ContactoIndividual;
import umu.tds.AppChat.dominio.Usuario;
import umu.tds.AppChat.service.ContactoIndividualService;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.vista.CrearContactoView;

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
		Usuario u = uService.findByNumTLF(telefono).get();
		ContactoIndividual c = new ContactoIndividual(nombre, u);
		cService.add(c);
	}
}
