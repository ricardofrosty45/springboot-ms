package com.university.project.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.project.dto.request.StudentRequestDTO;
import com.university.project.dto.response.GenericResponse;
import com.university.project.entities.Student;
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

	@GetMapping
	public ResponseEntity<List<Student>> getAllCreatedStudents() throws Exception {
		return new ResponseEntity<>(service.listAllStudents(), HttpStatus.OK);
	}

	@GetMapping("/information")
	public ResponseEntity<Student> getStudentById(@NotNull(message = "id cannot be null") @NotBlank(message = "id cannot be empty, please inform us a valid id")@RequestParam("id") String id) throws Exception {
		return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
	}

}
