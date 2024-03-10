package com.customermicroservice.response;

import java.io.Serializable;

// This class is used to model a response for the authentication request
public class AuthenticationResponse implements Serializable {
	
	private final String jwt;
	
	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}
	
	public String getJwt() {
		return jwt;
	}
}
