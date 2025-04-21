package umu.tds.AppChat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import umu.tds.dominio.Grupo;

@Repository
public interface GrupoDAO {
	
	List<Grupo> findAll();
	List<Grupo> findByName(String name);
	void add(Grupo g);
}
