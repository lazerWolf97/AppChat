package umu.tds.AppChat.service.implementation;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.ContactoIndividualDAO;
import umu.tds.AppChat.dto.ContactoIndividualDTO;
import umu.tds.AppChat.dto.mappers.MapStructMapper;
import umu.tds.AppChat.service.ContactoIndividualService;
import umu.tds.dominio.ContactoIndividual;

@Service
public class ContactoIndividualApp implements ContactoIndividualService {

	@Autowired
	private ContactoIndividualDAO repository;
	
	@Autowired
	private MapStructMapper mapper;
	
	@Override
	public List<ContactoIndividualDTO> findAll() {
		List<ContactoIndividual> lc = repository.findAll();
		List<ContactoIndividualDTO> lcDTO = new LinkedList<ContactoIndividualDTO>();
		lc.stream().forEach(c -> lcDTO.add(mapper.getDTO(c)));
		return lcDTO;
	}

	@Override
	public List<ContactoIndividualDTO> findByName(String name) {
		List<ContactoIndividual> lc = repository.findByName(name);
		List<ContactoIndividualDTO> lcDTO = new LinkedList<ContactoIndividualDTO>();
		lc.stream().forEach(c -> lcDTO.add(mapper.getDTO(c)));
		return lcDTO;
	}

	@Override
	public void add(ContactoIndividualDTO c) {
		repository.add(mapper.getContacto(c));
	}

	@Override
	public void delete(String ID) {
		repository.delete(ID);
	}

}
