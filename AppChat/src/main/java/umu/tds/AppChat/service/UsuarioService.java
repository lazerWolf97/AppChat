package umu.tds.AppChat.service;

import java.util.List;
import java.util.Optional;

import umu.tds.AppChat.dominio.Contacto;
import umu.tds.AppChat.dominio.Usuario;

public interface UsuarioService {
	public List<Usuario> findAll();
	public Optional<Usuario> login(String numTLF, String password);
	public void registrar(Usuario u);
	public void update(Usuario u);
	public Optional<Usuario> findByNumTLF(String numTLF);
	public List<Usuario> findByName(String name);
	public void delete(String numTLF);
}
