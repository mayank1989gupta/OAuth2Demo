/**
 * 
 */
package com.oauth2.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MGupta
 *
 */
@RestController
@RequestMapping(value="/api")
@Validated
public class Controller {

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public String hello() {
		return "Welcome!!";
	}
}
