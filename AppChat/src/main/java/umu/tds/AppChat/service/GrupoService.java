package umu.tds.AppChat.service;

import java.util.List;

import umu.tds.AppChat.dominio.Grupo;

public interface GrupoService {

	public List<Grupo> findAll();
	public List<Grupo> findByName(String name);
	public void add(Grupo g);
	public void delete(String ID);
	public void update(Grupo g);
}
