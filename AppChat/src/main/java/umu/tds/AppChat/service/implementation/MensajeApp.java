package umu.tds.AppChat.service.implementation;

import umu.tds.AppChat.service.MensajeService;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.MensajeDAO;
import umu.tds.AppChat.dominio.Mensaje;

@Service
public class MensajeApp implements MensajeService {

	@Autowired
	private MensajeDAO repository;

	@Override
	public List<Mensaje> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Mensaje> findAllByUser(String userID) {
		return repository.findByUser(userID);
	}
	
	@Override
	public List<Mensaje> findAllByTwoUsers(String firstuserID, String seconduserID){
		return repository.findChat(firstuserID, seconduserID);
	}
	
	@Override
	public List<Mensaje> findByUserAndText(String userID, String text) {
		return repository.findByUserAndText(userID, text);
		
	}

	@Override
	public void add(Mensaje m) {
		repository.add(m);
	}

}
