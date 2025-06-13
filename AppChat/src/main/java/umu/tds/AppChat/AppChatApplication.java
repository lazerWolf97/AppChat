package umu.tds.AppChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import umu.tds.AppChat.controller.LoginController;

@SpringBootApplication
@EntityScan(basePackages = "umu.tds.dominio")
public class AppChatApplication {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		ConfigurableApplicationContext context = SpringApplication.run(AppChatApplication.class);
		
		LoginController loginController = context.getBean(LoginController.class);
		
		javax.swing.SwingUtilities.invokeLater(() -> loginController.initialize());
	}

}
