package com.openwebinars.rest.users.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.openwebinars.rest.services.base.BaseService;
import com.openwebinars.rest.users.model.UserEntity;
import com.openwebinars.rest.users.repos.UserEntityRepository;

@Service
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository>{

	
	public Optional<UserEntity> findUserByUsername(String username) {
		return this.repositorio.findByUsername(username);
	}
	
	
}
