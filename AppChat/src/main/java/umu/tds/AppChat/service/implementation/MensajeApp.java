package umu.tds.AppChat.service.implementation;

import umu.tds.AppChat.service.MensajeService;
import umu.tds.dominio.Mensaje;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.MensajeDAO;

@Service
public class MensajeApp implements MensajeService {

	@Autowired
	private MensajeDAO repository;

	@Override
	public List<Mensaje> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Mensaje> findAllByUsername(String userID) {
		return repository.findByUser(userID);
	}

	@Override
	public void add(Mensaje m) {
		repository.add(m);
	}

}
