package umu.tds.AppChat.service;

import java.util.List;

import umu.tds.AppChat.dto.MensajeDTO;

public interface MensajeService {

	public List<MensajeDTO> findAll();
	public List<MensajeDTO> findAllByUsername(String userID);
	public void add(MensajeDTO m);
}
