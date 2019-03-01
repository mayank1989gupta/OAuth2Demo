/**
 * 
 */
package com.oauth2.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author MGupta
 *
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class OAuth2Application {

	public static void main(String args[]) {
		SpringApplication.run(OAuth2Application.class, args);
	}
}
