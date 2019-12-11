package com.openwebinars.rest.security.jwt.model;

import java.util.Set;

import com.openwebinars.rest.users.dto.GetUserDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends GetUserDto {
	
	private String token;
	
	@Builder(builderMethodName="jwtUserResponseBuilder")
	public JwtUserResponse(String username, String avatar, String fullName, String email, Set<String> roles, String token) {
		super(username, avatar, fullName, email, roles);
		this.token = token;
	}
	
	

}
