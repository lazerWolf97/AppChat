package umu.tds.AppChat.service.implementation;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.GrupoDAO;
import umu.tds.AppChat.service.GrupoService;
import umu.tds.dominio.Grupo;

@Service
public class GrupoApp implements GrupoService {
	
	@Autowired
	private GrupoDAO repository;

	@Override
	public List<Grupo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grupo> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Grupo g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String ID) {
		// TODO Auto-generated method stub
		
	}
	

	
	
}
