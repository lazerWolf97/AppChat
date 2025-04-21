package umu.tds.AppChat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import umu.tds.AppChat.dto.GrupoDTO;
import umu.tds.AppChat.service.GrupoService;

@RestController
@RequestMapping("/appchat/contactos")
public class GrupoController {

	@Autowired
	private GrupoService service;
	
	@GetMapping("/grupos")
	public List<GrupoDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/grupos/name={name}")
	public List<GrupoDTO> findByName(String name) {
		return service.findByName(name);
	}
	
	@PostMapping("/grupos/add")
	public void add(@RequestBody GrupoDTO g) {
		service.add(g);
	}
	
}
