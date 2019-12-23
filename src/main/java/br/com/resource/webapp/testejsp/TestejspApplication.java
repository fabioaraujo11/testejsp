package br.com.resource.webapp.testejsp;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.resource.webapp.testejsp.controllers.EventoController;

@SpringBootApplication
public class TestejspApplication {

	public static void main(String[] args) {
		new File(EventoController.uploadDirectory).mkdir();
		SpringApplication.run(TestejspApplication.class, args);
	}

}
