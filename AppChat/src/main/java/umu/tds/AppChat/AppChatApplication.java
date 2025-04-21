package umu.tds.AppChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "umu.tds.dominio")
public class AppChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppChatApplication.class, args);
	}

}
