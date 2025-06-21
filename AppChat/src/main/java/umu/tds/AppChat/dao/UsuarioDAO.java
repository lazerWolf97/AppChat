package umu.tds.AppChat.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dominio.Contacto;
import umu.tds.AppChat.dominio.Usuario;

@Repository
public interface UsuarioDAO {

	List<Usuario> findAll();
	List<Usuario> findByName(String name);
	Optional<Usuario> findByID(String ID);
	void add(Usuario u);
	void update(Usuario u);
	void delete(String ID);
}
