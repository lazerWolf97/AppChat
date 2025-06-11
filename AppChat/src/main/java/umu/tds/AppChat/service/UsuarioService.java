package umu.tds.AppChat.service;

import java.util.List;

import umu.tds.AppChat.dto.UsuarioDTO;

public interface UsuarioService {
	public List<UsuarioDTO> findAll();
	public void add(UsuarioDTO u);
	public void update(UsuarioDTO u);
	public UsuarioDTO findByID(String ID);
	public List<UsuarioDTO> findByName(String NAME);
	public void delete(String ID);
}
