package com.university.project.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.project.dto.request.StudentRequestDTO;
import com.university.project.dto.request.UpdateStudentRequestDTO;
import com.university.project.dto.response.GenericResponse;
import com.university.project.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService service;

	@PostMapping
	public ResponseEntity<GenericResponse> registerNewStudent(@RequestBody @Valid StudentRequestDTO request) throws Exception {
		return new ResponseEntity<>(service.registerNewStudentIntoUniversity(request), HttpStatus.CREATED);
	}
	
	
	@PutMapping
	public ResponseEntity<GenericResponse> updateStudentProfile(@RequestBody @Valid UpdateStudentRequestDTO request){
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
