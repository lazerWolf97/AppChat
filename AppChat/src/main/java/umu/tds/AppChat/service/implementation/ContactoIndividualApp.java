package umu.tds.AppChat.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.ContactoIndividualDAO;
import umu.tds.AppChat.service.ContactoIndividualService;
import umu.tds.dominio.ContactoIndividual;

@Service
public class ContactoIndividualApp implements ContactoIndividualService {

	@Autowired
	private ContactoIndividualDAO repository;

	@Override
	public List<ContactoIndividual> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactoIndividual> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(ContactoIndividual c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String ID) {
		// TODO Auto-generated method stub
		
	}
	
	

}
