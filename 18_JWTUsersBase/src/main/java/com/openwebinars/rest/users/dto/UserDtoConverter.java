package com.openwebinars.rest.users.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.openwebinars.rest.users.model.UserEntity;
import com.openwebinars.rest.users.model.UserRole;

@Component
public class UserDtoConverter {
	
	public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
		return GetUserDto.builder()
				.username(user.getUsername())
				.avatar(user.getAvatar())
				.fullName(user.getFullName())
				.email(user.getEmail())
				.roles(user.getRoles().stream()
							.map(UserRole::name)
							.collect(Collectors.toSet())
				).build();
	}

}
