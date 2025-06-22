package umu.tds.AppChat.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import umu.tds.AppChat.dominio.ContactoIndividual;

@Repository
public interface ContactoIndividualDAO {

	List<ContactoIndividual> findAll();
	List<ContactoIndividual> findByName(String name);
	List<ContactoIndividual> findByNameAndUser(String name, String userID);
	Optional<ContactoIndividual> findByID(long ID);
	void add(ContactoIndividual c);
	void delete(long ID);
	void update(ContactoIndividual c);
}
