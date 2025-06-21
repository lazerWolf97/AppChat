package umu.tds.AppChat.service.implementation;

import umu.tds.AppChat.service.MensajeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	public List<Mensaje> findLastByUser(String userID) {
		List<Mensaje> mensajes = repository.findByUser(userID);
		Map<String, Mensaje> ultimosPorChat = new HashMap<>();

		for (Mensaje mensaje : mensajes) {
			String otroID;
	        if (mensaje.getEmisor().getNumTLF().equals(userID)) {
	        	otroID = mensaje.getReceptor().getNumTLF();
	        } else {
	        	otroID = mensaje.getEmisor().getNumTLF();
	        }

	        Mensaje existente = ultimosPorChat.get(otroID);
	        if (existente == null || mensaje.getFechaHora().isAfter(existente.getFechaHora())) {
	        	ultimosPorChat.put(otroID, mensaje);
	        }
		}

		return new ArrayList<>(ultimosPorChat.values());
		
	}

	@Override
	public void add(Mensaje m) {
		repository.add(m);
	}

}
