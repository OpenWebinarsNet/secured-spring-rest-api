package com.openwebinars.rest.security.oauth2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter{

	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final DataSource dataSource;
	
	@Value("${oauth2.client-id}")
	private String clientId;
	
	@Value("${oauth2.client-secret}")
	private String clientSecret;
	
	@Value("${oauth2.redirect-uri}")
	private String redirectUri;
	
	@Value("${oauth2.access-token-validity-seconds}")
	private int accessTokenValiditySeconds;
	
	@Value("${oauth2.access-token-validity-seconds}")
	private int refreshTokenValiditySeconds;
	
	

	
	private static final String CODE_GRANT_TYPE = "authorization_code";
	private static final String IMPLICIT_GRANT_TYPE = "implicit";
	private static final String PASS_GRANT_TYPE = "password";
	private static final String REFRESH_TOKEN_GRANT_TYPE = "refresh_token";
	
	

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
			.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()")
			.allowFormAuthenticationForClients();

	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.jdbc(dataSource)
			.withClient(clientId)
			.secret(passwordEncoder.encode(clientSecret))
			.authorizedGrantTypes(PASS_GRANT_TYPE, REFRESH_TOKEN_GRANT_TYPE, IMPLICIT_GRANT_TYPE, CODE_GRANT_TYPE)
			.authorities("READ_ONLY_CLIENT")
			.scopes("read")
			.resourceIds("oauth2-resource")
			.redirectUris(redirectUri)
			.accessTokenValiditySeconds(accessTokenValiditySeconds)
			.refreshTokenValiditySeconds(refreshTokenValiditySeconds);
			
	
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService)
			.tokenStore(tokenStore())
			.accessTokenConverter(accessTokenConverter());
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}
	
	@Bean
	public AccessTokenConverter accessTokenConverter() {
		return new JwtAccessTokenConverter();
	}

	
	
	
}
