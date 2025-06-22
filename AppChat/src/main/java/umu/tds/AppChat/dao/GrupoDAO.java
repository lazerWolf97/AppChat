package umu.tds.AppChat.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dominio.Grupo;

@Repository
public interface GrupoDAO {
	
	List<Grupo> findAll();
	List<Grupo> findByName(String name);
	Optional<Grupo> findByID(long ID);
	void add(Grupo g);
	void delete(long ID);
	void update(Grupo g);
}
