package umu.tds.AppChat.service;

import java.util.List;

import umu.tds.AppChat.dto.ContactoIndividualDTO;

public interface ContactoIndividualService {

	public List<ContactoIndividualDTO> findAll();
	public List<ContactoIndividualDTO> findByName(String name);
	public void add(ContactoIndividualDTO c);
	public void delete(String ID);
}
