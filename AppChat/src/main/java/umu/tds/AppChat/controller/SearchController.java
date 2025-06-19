package umu.tds.AppChat.controller;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import umu.tds.AppChat.service.MensajeService;
import umu.tds.AppChat.vista.SearchView;

@Component
public class SearchController {

	private final MensajeService mService;
	private final AppController controller;
	
	public SearchController(MensajeService mService, AppController controller) {
		this.mService = mService;
		this.controller = controller;
	}
	
	public void initialize() {
		SearchView view = new SearchView(this);
		view.showWindow();
	}
	
	public void volver() {
		
	}
	
}
