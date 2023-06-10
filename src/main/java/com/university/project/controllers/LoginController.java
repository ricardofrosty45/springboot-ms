package com.university.project.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.project.dto.request.LoginRequestDTO;
import com.university.project.dto.response.LoginResponseDTO;
import com.university.project.service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService service;
	
	
	@PostMapping
	public ResponseEntity<LoginResponseDTO> makeLogin(@RequestBody @Valid LoginRequestDTO request) throws Exception {
		return new ResponseEntity<>(service.makeStudentLoginAndGenerateToken(request), HttpStatus.CREATED);
	}

}
