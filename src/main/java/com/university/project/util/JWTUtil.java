package com.university.project.util;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.university.project.enums.Roles;
import com.university.project.exceptions.GeneralException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	public String generateJwtToken(String username, String secret, long expiration, Roles userRole) {

		Date dateNow = Date.from(LocalDateTime.now().plusHours(5).atZone(ZoneId.systemDefault()).toInstant());
		return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(dateNow)
				.claim("ROLE", userRole.toString()).signWith(this.key(secret), SignatureAlgorithm.HS256).compact();

	}

	private Key key(String secret) {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}

	public boolean validateJwtToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(this.key(token)).build().parse(token);
			return true;
		} catch (MalformedJwtException e) {
			throw new GeneralException("Your token is malformed", HttpStatus.UNAUTHORIZED);
		} catch (ExpiredJwtException e) {
			throw new GeneralException("Your token got expired", HttpStatus.UNAUTHORIZED);
		} catch (UnsupportedJwtException e) {
			throw new GeneralException("Your token is unsupported", HttpStatus.UNAUTHORIZED);
		}
	}

}
