package umu.tds.AppChat.service;

import java.util.List;

import umu.tds.AppChat.dominio.ContactoIndividual;

public interface ContactoIndividualService {

	public List<ContactoIndividual> findAll();
	public List<ContactoIndividual> findByName(String name);
	public List<ContactoIndividual> findByNameAndUser(String name, String userID);
	public void add(ContactoIndividual c);
	public void delete(String ID);
	public void update(ContactoIndividual c);
}
