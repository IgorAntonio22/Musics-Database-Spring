package com.IgorAntonio22;

import com.IgorAntonio22.Principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.IgorAntonio22.service.ArtistaService;
import com.IgorAntonio22.service.MusicaService;
@SpringBootApplication
public class MusicsDatabaseApplication implements CommandLineRunner {

	@Autowired
	ArtistaService artistaService;

	@Autowired
	MusicaService musicaService;

	public static void main(String[] args) {

		SpringApplication.run(MusicsDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(artistaService, musicaService);
		principal.exibeMenu();
		System.exit(0);
	}
}
