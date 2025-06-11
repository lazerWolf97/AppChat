package umu.tds.AppChat.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umu.tds.AppChat.dao.UsuarioDAO;
import umu.tds.AppChat.dto.UsuarioDTO;
import umu.tds.AppChat.dto.mappers.MapStructMapper;
import umu.tds.AppChat.service.UsuarioService;
import umu.tds.dominio.*;

@Service
public class UsuarioApp implements UsuarioService {

	@Autowired
	private UsuarioDAO repository;
	
	@Autowired
	private MapStructMapper mapper;
	
	@Override
	public List<UsuarioDTO> findAll() {
		List<Usuario> lu = repository.findAll();
		List<UsuarioDTO> ludto = new ArrayList<UsuarioDTO>();
		lu.stream().forEach(u -> ludto.add(mapper.getDTO(u)));
		return ludto;
	}

	@Override
	public void add(UsuarioDTO u) {
		repository.add(mapper.getUsuario(u));
	}

	@Override
	public void update(UsuarioDTO u) {
		repository.update(mapper.getUsuario(u));
	}

	@Override
	public UsuarioDTO findByID(String ID) {
		Optional<Usuario> p = repository.findByID(ID);
		if(!p.isPresent()) {
			throw new RuntimeException("Error: Usuario con ID " + ID + " no encontrado.");
		}
		return mapper.getDTO(p.get());
	}

	@Override
	public List<UsuarioDTO> findByName(String NAME) {
		List<Usuario> p = repository.findByName(NAME);
		List<UsuarioDTO> pnew = new ArrayList<UsuarioDTO>();
		p.stream().forEach(u -> pnew.add(mapper.getDTO(u)));
		return pnew;
	}

	@Override
	public void delete(String ID) {
		repository.delete(ID);
	}

}
