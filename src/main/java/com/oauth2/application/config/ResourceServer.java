/**
 * 
 */
package com.oauth2.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author MGupta</br>
 * 
 * This class is enabler for the Resource Server.</br>
 * Basically the resource would be the Rest API that we want to secure.</br>
 */
@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "resource_id";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure (HttpSecurity http) throws Exception {
		//For oauth
		http
		.authorizeRequests()
		.antMatchers("/oauth/token", "/oauth/authorize **", "/publishes")
		.permitAll(); 
		
		//for resource
		http
		.requestMatchers().antMatchers("/api/user") // Deny access to "/ private"
		.and()
		.authorizeRequests()
		.antMatchers("/api/user").access("hasRole('USER')")
		.and()
		.authorizeRequests()
		.antMatchers("/api/user").access("hasRole('ADMIN')")
		.and()
		.requestMatchers()
		.antMatchers("/api/admin") // Deny access to "/ admin"
		.and()
		.authorizeRequests()
		.antMatchers("/api/admin")
		.access("hasRole ('ADMIN')");
	}
}
