package umu.tds.AppChat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dominio.ContactoIndividual;

@Repository
public interface ContactoIndividualDAO {

	List<ContactoIndividual> findAll();
	List<ContactoIndividual> findByName(String name);
	List<ContactoIndividual> findByNameAndUser(String name, String userID);
	void add(ContactoIndividual c);
	void delete(String ID);
	void update(ContactoIndividual c);
}
