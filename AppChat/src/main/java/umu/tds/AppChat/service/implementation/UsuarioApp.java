package umu.tds.AppChat.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.UsuarioDAO;
import umu.tds.AppChat.dominio.CatalogoUsuarios;
import umu.tds.AppChat.dominio.Usuario;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.exceptions.UserException;
import umu.tds.exceptions.UserException.UserErrorType;

@Service
public class UsuarioApp implements UsuarioService {

	@Autowired
	private CatalogoUsuarios catalogo;
	
	@Autowired
	private UsuarioDAO repository;

	@Override
	public List<Usuario> findAll() {
		return catalogo.getUsuarios();
	}

	@Override
	public Optional<Usuario> login(String numTLF, String password) {
		Optional<Usuario> u = repository.findByID(numTLF);
		
		if(u.isEmpty())
			throw new UserException("Usuario no encontrado.", UserErrorType.LOGINID);
		
		if(password.compareTo(u.get().getPassword()) != 0) 
			throw new UserException("Contraseña incorrecta.", UserErrorType.LOGINPASSWORD);
		
		return u;
	}

	@Override
	public void registrar(Usuario u) {
		Optional<Usuario> uopt = repository.findByID(u.getNumTLF());
		if(uopt.isPresent())
			throw new UserException("Ya existe un usuario con ese número.", UserErrorType.SIGNUPALREADYEXISTS);
		repository.add(u);
		catalogo.reload();
	}

	@Override
	public void update(Usuario u) {
		repository.update(u);
		catalogo.reload();
	}

	@Override
	public Optional<Usuario> findByNumTLF(String numTLF) {
		Optional<Usuario> uopt = catalogo.getUsuario(numTLF);
		if(uopt.isEmpty())
			throw new UserException("Usuario no encontrado.", UserErrorType.USERNOTFOUND);
		
		return uopt;
	}

	@Override
	public List<Usuario> findByName(String name) {
		List<Usuario> lu = catalogo.getUsuarioByName(name);
		if(lu.isEmpty())
			throw new UserException("Usuario no encontrado.", UserErrorType.USERNOTFOUND);
		return lu;
	}

	@Override
	public void delete(String numTLF) {
		repository.delete(numTLF);
		catalogo.reload();
	}
}
