package umu.tds.AppChat.service;

import java.util.List;

import umu.tds.AppChat.dominio.Mensaje;

public interface MensajeService {

	public List<Mensaje> findAll();
	public List<Mensaje> findAllByUser(String userID);
	public List<Mensaje> findAllByTwoUsers(String firstuserID, String seconduserID);
	public List<Mensaje> findByUserAndText(String userID, String text);
	public void add(Mensaje m);
}
