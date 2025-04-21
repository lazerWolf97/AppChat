package umu.tds.AppChat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import umu.tds.AppChat.dto.MensajeDTO;
import umu.tds.AppChat.service.MensajeService;

@RestController
@RequestMapping("/appchat/mensajes")
public class MensajeController {

	@Autowired
	private MensajeService service;
	
	@GetMapping
	public List<MensajeDTO> findAll(){
		return service.findAll();
	}
	
}
