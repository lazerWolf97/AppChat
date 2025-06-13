package umu.tds.AppChat.service;

import java.util.List;

import umu.tds.dominio.Mensaje;

public interface MensajeService {

	public List<Mensaje> findAll();
	public List<Mensaje> findAllByUsername(String userID);
	public void add(Mensaje m);
}
