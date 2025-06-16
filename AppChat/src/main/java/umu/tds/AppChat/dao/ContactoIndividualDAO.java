package umu.tds.AppChat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import umu.tds.dominio.ContactoIndividual;

@Repository
public interface ContactoIndividualDAO {

	List<ContactoIndividual> findAll();
	List<ContactoIndividual> findByName(String name);
	void add(ContactoIndividual c);
	void delete(String ID);
}
