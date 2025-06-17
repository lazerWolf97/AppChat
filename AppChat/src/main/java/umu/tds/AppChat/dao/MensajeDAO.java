package umu.tds.AppChat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import umu.tds.dominio.Mensaje;

@Repository
public interface MensajeDAO {

	List<Mensaje> findAll();
	List<Mensaje> findByUser(String userID);
	List<Mensaje> findByEmisor(String userID);
	List<Mensaje> findByReceptor(String userID);
	List<Mensaje> findByUserAndText(String userID, String text);
	void add(Mensaje m);
	void delete(String ID);
	
}
