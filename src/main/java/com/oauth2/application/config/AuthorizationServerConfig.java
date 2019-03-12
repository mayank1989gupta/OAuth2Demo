/**
 * 
 */
package com.oauth2.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author MGupta
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final String CLIENT_ID = "client";
	/**
	 * Encoding method prefix is required for DelegatingPasswordEncoder which is 
	 * default since Spring Security 5.0.0.RC1. </br>
	 */
	static final String CLIENT_SECRET = "password";

	private static final String GRANT_TYPE_PASSWORD = "password";
	private static final String AUTHORIZATION_CODE = "authorization_code";
	private static final String REFRESH_TOKEN = "refresh_token";
	private static final String IMPLICIT = "implicit";
	private static final String SCOPE_READ = "read";
	private static final String SCOPE_WRITE = "write";
	private static final String ROLE_CLIENT = "ROLE_CLIENT";
	private static final String ROLE_TRUSTED_CLIENT = "ROLE_TRUSTED_CLIENT";
	private static final String USER = "USER";

	@Autowired
	private AuthenticationManager authManager;

	//In order to inject this --> the same is defined in the method below
	@Autowired
	private TokenStore tokenStore; //stores the identifiers   

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory ()
		.withClient (CLIENT_ID)
		.authorizedGrantTypes (GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT)
		.authorities (ROLE_CLIENT, ROLE_TRUSTED_CLIENT, USER)
		.scopes(SCOPE_READ, SCOPE_WRITE)
		.autoApprove(Boolean.TRUE)        
		.secret(passwordEncoder().encode(CLIENT_SECRET))
		.accessTokenValiditySeconds(60).refreshTokenValiditySeconds(5000);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.tokenStore(tokenStore)
		.authenticationManager(authManager);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore ();
	}
}
