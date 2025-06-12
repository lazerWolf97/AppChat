package umu.tds.AppChat.dao;

import java.util.List;

import umu.tds.dominio.Contacto;

public interface ContactoDAO {

	List<Contacto> findAll();
	List<Contacto> findByName(String name);
	
}
