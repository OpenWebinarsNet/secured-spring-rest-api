package com.openwebinars.rest;

import java.util.Arrays;

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
			
			
//			Arrays.asList("Admin1", "Marialopez1", "Angelmartinez1", "Anajimenez1").forEach(
//					pass -> System.out.println(pass + ": " + passwordEncoder.encode(pass))
//					
//					);
			
			
			
		};

	}

}
