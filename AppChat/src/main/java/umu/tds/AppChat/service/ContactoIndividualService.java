package umu.tds.AppChat.service;

import java.util.List;

import umu.tds.dominio.ContactoIndividual;

public interface ContactoIndividualService {

	public List<ContactoIndividual> findAll();
	public List<ContactoIndividual> findByName(String name);
	public void add(ContactoIndividual c);
	public void delete(String ID);
}
