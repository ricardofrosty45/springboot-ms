package com.university.project.controllers;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.project.entities.SystemUser;
import com.university.project.service.StudentService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value = "/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final StudentService service;
	
	
	@GetMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<List<SystemUser>> getAllCreatedStudents() throws Exception {
		return new ResponseEntity<>(service.listAllStudents(), HttpStatus.OK);
	}

	@GetMapping("/information")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<SystemUser> getStudentById(@NotNull(message = "id cannot be null") @NotBlank(message = "id cannot be empty, please inform us a valid id")@RequestParam("id") String id) throws Exception {
		return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
	}

}
