/**
 * 
 */
package com.oauth2.application.model;

/**
 * @author MGupta
 *
 */
public class Greeting {

	private static final String GREETINGS_FORMAT = "Welcome %s!";

	public String greetings;

	public Greeting() {}

	public Greeting(String client) {
		this.greetings = String.format(GREETINGS_FORMAT, client);
	}

	/**
	 * @return the greetings
	 */
	public String getGreetings() {
		return greetings;
	}

	/**
	 * @param greetings the greetings to set
	 */
	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}
}
