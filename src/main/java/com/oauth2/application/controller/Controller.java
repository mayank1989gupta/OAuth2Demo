/**
 * 
 */
package com.oauth2.application.controller;

import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oauth2.application.model.Greeting;

/**
 * @author MGupta
 *
 */
@RestController
@RequestMapping(value="/api")
@Validated
public class Controller {

	@GetMapping("/user")
	@ResponseStatus(HttpStatus.OK)
	public Greeting helloUser() {
		Supplier<Greeting> greeting = () -> new Greeting("hello user");
		//result
		return greeting.get();
	}
	
	@GetMapping("/admin")
	@ResponseStatus(HttpStatus.OK)
	public Greeting helloAdmin() {
		Supplier<Greeting> greeting = () -> new Greeting("hello admin");
		//result
		return greeting.get();
	}
	
	@GetMapping("/public")
	@ResponseStatus(HttpStatus.OK)
	public Greeting helloPublic() {
		Supplier<Greeting> greeting = () -> new Greeting("hello public");
		//result
		return greeting.get();
	}
	
}
