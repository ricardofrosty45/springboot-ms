package com.university.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.university.project.dto.request.LoginRequestDTO;
import com.university.project.dto.response.LoginResponseDTO;
import com.university.project.entities.SystemUser;
import com.university.project.exceptions.GeneralException;
import com.university.project.repository.SystemUserRepository;
import com.university.project.util.JWTUtil;

@Service
public class LoginService {

	private final String jwtSecret;

	private final long jwtExpiration;

	private final SystemUserRepository repository;

	public LoginService(@Value("${application.jwt.secret}") String jwtSecret,
			@Value("${application.jwt.token.expiration.ms}") long jwtExpiration, SystemUserRepository repository) {
		this.jwtSecret = jwtSecret;
		this.jwtExpiration = jwtExpiration;
		this.repository = repository;
	}

	public LoginResponseDTO makeStudentLoginAndGenerateToken(LoginRequestDTO request) {
		SystemUser userDb = repository.findByUsername(request.getUsername());

		Optional.ofNullable(userDb).ifPresentOrElse(user -> {
			if (!user.getPassword().equals(request.getPassword())) {
				throw new GeneralException("Password does not match", HttpStatus.BAD_REQUEST);
			}
		}, () -> {
			throw new GeneralException("User does not exist", HttpStatus.NOT_FOUND);
		});

		return LoginResponseDTO.builder().token(
				new JWTUtil().generateJwtToken(request.getUsername(), jwtSecret, jwtExpiration, userDb.getUserRole()))
				.build();
	}

}
