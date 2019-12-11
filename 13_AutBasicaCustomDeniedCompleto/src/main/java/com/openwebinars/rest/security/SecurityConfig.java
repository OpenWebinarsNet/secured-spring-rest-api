package com.openwebinars.rest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	private final CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	private final AccessDeniedHandler accessDeniedHandler;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.authenticationEntryPoint(customBasicAuthenticationEntryPoint)
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/producto/**", "/lote/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/producto/**", "/lote/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/producto/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/producto/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/pedido/**").hasAnyRole("USER","ADMIN")
				.anyRequest().authenticated()
			.and()
				.csrf().disable();
		
		http.exceptionHandling()
			.accessDeniedHandler(accessDeniedHandler);
		
	}
	
	
	
	
}
