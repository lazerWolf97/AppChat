package umu.tds.AppChat.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.ContactoIndividualDAO;
import umu.tds.AppChat.dominio.ContactoIndividual;
import umu.tds.AppChat.dominio.Grupo;
import umu.tds.AppChat.service.ContactoIndividualService;
import umu.tds.exceptions.UserException;
import umu.tds.exceptions.UserException.UserErrorType;

@Service
public class ContactoIndividualApp implements ContactoIndividualService {

	@Autowired
	private ContactoIndividualDAO repository;

	@Override
	public List<ContactoIndividual> findAll() {
		return repository.findAll();
	}

	@Override
	public List<ContactoIndividual> findByName(String name) {
		List<ContactoIndividual> lc = repository.findByName(name);
		if(lc.isEmpty())
			throw new UserException("No existe un contacto con ese nombre.", UserErrorType.USERNOTFOUND);
		return lc;
	}
	
	@Override
	public List<ContactoIndividual> findByNameAndUser(String name, String userID) {
		List<ContactoIndividual> lc = repository.findByName(name);
		if(lc.isEmpty())
			throw new UserException("No existe un contacto con ese nombre.", UserErrorType.USERNOTFOUND);
		return lc;
	}

	@Override
	public void add(ContactoIndividual c) {
		repository.add(c);
	}

	@Override
	public void delete(String ID) {
		repository.delete(ID);
	}

	@Override
	public void update(ContactoIndividual c) {
		repository.update(c);
	}

	@Override
	public void addOrUpdate(ContactoIndividual c) {
		if(c.getID() == null) {
			repository.add(c);
		}
		else {
			repository.update(c);
		}
	}

}
