package com.aluracursos.desafio;

import com.aluracursos.desafio.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Creando una instancia de mi clase Principal
		Principal mostrar = new Principal();
		mostrar.mostrarElMenu();


	}
}
