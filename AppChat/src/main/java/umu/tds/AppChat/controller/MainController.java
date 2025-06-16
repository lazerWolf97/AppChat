package umu.tds.AppChat.controller;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.service.UsuarioService;
import umu.tds.AppChat.vista.MainView;

@Component
public class MainController {

	private UsuarioService uService;
	
	public MainController(UsuarioService uService) {
		this.uService = uService;
	}
	
	public void initialize() {
		MainView mv = new MainView(this);
		mv.showWindow();
	}
	
}
