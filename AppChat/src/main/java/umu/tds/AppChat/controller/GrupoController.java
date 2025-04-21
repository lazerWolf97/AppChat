package umu.tds.AppChat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import umu.tds.AppChat.dto.GrupoDTO;
import umu.tds.AppChat.service.GrupoService;

@RestController
@RequestMapping("/appchat/contactos/grupos")
public class GrupoController {

	@Autowired
	private GrupoService service;
	
	@GetMapping
	public List<GrupoDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{name}")
	public List<GrupoDTO> findByName(String name) {
		return service.findByName(name);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody GrupoDTO g) {
		service.add(g);
	}
	
}
