package umu.tds.AppChat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import umu.tds.AppChat.dto.UsuarioDTO;
import umu.tds.AppChat.dto.UsuarioPostDTO;
import umu.tds.AppChat.service.UsuarioService;

@RestController
@RequestMapping("/appchat")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/usuarios")
	public List<UsuarioDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/usuarios/id={userID}")
	public UsuarioDTO findByID(@PathVariable String userID) {
		return service.findByID(userID);
	}
	
	@PostMapping("/usuarios/add")
	public void add(@RequestBody UsuarioPostDTO u) {
		service.add(u);
	}
	
	@PostMapping("/usuarios/update")
	public void update(@RequestBody UsuarioPostDTO u) {
		service.update(u);
	}
	
	@DeleteMapping("/usuarios/delete/id={userID}")
	public void delete(@PathVariable String userID) {
		service.delete(userID);
	}
	
}
