package com.openwebinars.rest.users.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.openwebinars.rest.users.model.UserEntity;
import com.openwebinars.rest.users.services.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserEntityService userEntityService;

	@PostMapping("/")
	public UserEntity nuevoUsuario(@RequestBody UserEntity newUser) {
		try {
			return userEntityService.nuevoUsuario(newUser);
		} catch (DataIntegrityViolationException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

}
