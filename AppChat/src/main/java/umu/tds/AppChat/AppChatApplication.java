package umu.tds.AppChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import umu.tds.AppChat.controller.AppController;

@SpringBootApplication
@EntityScan(basePackages = "umu.tds.AppChat.dominio")
@ComponentScan(basePackages = "umu.tds.AppChat")
public class AppChatApplication {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		ConfigurableApplicationContext context = SpringApplication.run(AppChatApplication.class);
		
		AppController contextController = context.getBean(AppController.class);
		
		javax.swing.SwingUtilities.invokeLater(() -> contextController.mostrarLogin());
	}

}
