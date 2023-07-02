package com.university.project.config;

import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Credentials {

	public enum CredentialType {
		ID_TOKEN, SESSION
	}

	private CredentialType type;
	private DecodedJWT decodedToken;
	private String idToken;
}
