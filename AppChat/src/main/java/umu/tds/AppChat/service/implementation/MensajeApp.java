package umu.tds.AppChat.service.implementation;

import umu.tds.AppChat.service.MensajeService;
import umu.tds.dominio.Mensaje;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.MensajeDAO;
import umu.tds.AppChat.dto.MensajeDTO;
import umu.tds.AppChat.dto.mappers.MapStructMapper;

@Service
public class MensajeApp implements MensajeService {

	@Autowired
	private MensajeDAO repository;
	
	@Autowired
	private MapStructMapper mapper;
	
	@Override
	public List<MensajeDTO> findAll() {
		List<Mensaje> lm = repository.findAll();
		List<MensajeDTO> lmdto = new LinkedList<MensajeDTO>();
		lm.stream().forEach(m -> lmdto.add(mapper.getDTO(m)));
		return lmdto;
	}

	@Override
	public List<MensajeDTO> findAllByUsername(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(MensajeDTO m) {
		// TODO Auto-generated method stub
		
	}
}
