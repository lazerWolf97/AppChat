package umu.tds.AppChat.service.implementation;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.GrupoDAO;
import umu.tds.AppChat.dto.GrupoDTO;
import umu.tds.AppChat.dto.mappers.MapStructMapper;
import umu.tds.AppChat.service.GrupoService;
import umu.tds.dominio.Grupo;

@Service
public class GrupoApp implements GrupoService {
	
	@Autowired
	private GrupoDAO repository;
	
	@Autowired
	private MapStructMapper mapper;

	@Override
	public List<GrupoDTO> findAll() {
		List<Grupo> lg = repository.findAll();
		List<GrupoDTO> lgDTO = new LinkedList<GrupoDTO>();
		lg.stream().forEach(g -> lgDTO.add(mapper.getDTO(g)));
		return lgDTO;
	}

	@Override
	public List<GrupoDTO> findByName(String name) {
		List<Grupo> lg = repository.findByName(name);
		List<GrupoDTO> lgDTO = new LinkedList<GrupoDTO>();
		lg.stream().forEach(g -> lgDTO.add(mapper.getDTO(g)));
		return lgDTO;
	}

	@Override
	public void add(GrupoDTO g) {
		repository.add(mapper.getGrupo(g));
	}
	
	
}
