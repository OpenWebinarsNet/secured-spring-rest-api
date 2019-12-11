package com.openwebinars.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.openwebinars.rest.upload.StorageService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner init(StorageService storageService, PasswordEncoder passwordEncoder) {
		return args -> {
			// Inicializamos el servicio de ficheros
			storageService.deleteAll();
			storageService.init();
			
			
//			System.out.println("Admin1: " + passwordEncoder.encode("Admin1"));
//			System.out.println("Marialopez1: " + passwordEncoder.encode("Marialopez1"));
//			System.out.println("Angelmartinez1: " + passwordEncoder.encode("Angelmartinez1"));
//			System.out.println("Anajimenez1: " + passwordEncoder.encode("Anajimenez1"));
			
		};

	}

}
