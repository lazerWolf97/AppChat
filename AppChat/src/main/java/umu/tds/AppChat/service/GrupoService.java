package umu.tds.AppChat.service;

import java.util.List;

import umu.tds.AppChat.dto.GrupoDTO;

public interface GrupoService {

	public List<GrupoDTO> findAll();
	public List<GrupoDTO> findByName(String name);
	public void add(GrupoDTO g);
	
}
