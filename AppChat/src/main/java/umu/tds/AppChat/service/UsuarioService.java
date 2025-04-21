package umu.tds.AppChat.service;

import java.util.List;

import umu.tds.AppChat.dto.UsuarioDTO;
import umu.tds.AppChat.dto.UsuarioPostDTO;

public interface UsuarioService {
	public List<UsuarioDTO> findAll();
	public void add(UsuarioPostDTO u);
	public void update(UsuarioPostDTO u);
	public UsuarioDTO findByID(String ID);
	public List<UsuarioDTO> findByName(String NAME);
	public void delete(String ID);
}
