package umu.tds.AppChat.service.implementation;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.GrupoDAO;
import umu.tds.AppChat.dominio.Grupo;
import umu.tds.AppChat.service.GrupoService;
import umu.tds.exceptions.UserException;
import umu.tds.exceptions.UserException.UserErrorType;

@Service
public class GrupoApp implements GrupoService {
	
	@Autowired
	private GrupoDAO repository;

	@Override
	public List<Grupo> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Grupo> findByName(String name) {
		List<Grupo> lf = repository.findByName(name);
		if(lf.isEmpty())
			throw new UserException("No existe un grupo con ese nombre.", UserErrorType.USERNOTFOUND);
		return lf;
	}

	@Override
	public void add(Grupo g) {
		repository.add(g);
	}

	@Override
	public void delete(String ID) {
		repository.delete(ID);
	}
	
}
