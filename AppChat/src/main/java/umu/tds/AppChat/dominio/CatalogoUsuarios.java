package umu.tds.AppChat.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import umu.tds.AppChat.dao.UsuarioDAO;

@Component
public class CatalogoUsuarios {

	private List<Usuario> usuarios;
	
	@Autowired
	private UsuarioDAO repository;
	
	@PostConstruct
	public void init() {
		this.usuarios = repository.findAll();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Optional<Usuario> getUsuario(String numTLF) {
		return usuarios.stream().filter(u -> u.getNumTLF().compareTo(numTLF) == 0).findFirst();
	}
	
	public List<Usuario> getUsuarioByName(String name) {
		return usuarios.stream().filter(u -> name.contains(u.getNombre())).toList();
	}
	
	public void reload() {
		this.usuarios = repository.findAll();
	}
}
