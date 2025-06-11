package umu.tds.AppChat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import umu.tds.AppChat.dto.UsuarioDTO;
import umu.tds.AppChat.service.UsuarioService;

@RestController
@RequestMapping("/appchat/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public List<UsuarioDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{userID}")
	public UsuarioDTO findByID(@PathVariable String userID) {
		return service.findByID(userID);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody UsuarioDTO u) {
		service.add(u);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UsuarioDTO u) {
		service.update(u);
	}
	
	@DeleteMapping("/delete/{userID}")
	public void delete(@PathVariable String userID) {
		service.delete(userID);
	}
	
}
