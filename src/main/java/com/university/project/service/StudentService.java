package com.university.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.university.project.dto.request.StudentRequestDTO;
import com.university.project.dto.response.GenericResponse;
import com.university.project.entities.Student;
import com.university.project.exceptions.GeneralException;
import com.university.project.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository repository;

	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public GenericResponse registerNewStudentIntoUniversity(StudentRequestDTO request) {
		repository.save(new Student(request.getUsername(), request.getName(), request.getTypeOfGraduation(),
				request.getBirthDate()));
		return new GenericResponse("Student Created!", 201);
	}

	public List<Student> listAllStudents() {
		return repository.findAll();
	}
	
	
	public Student getStudentById(String id) {
		return repository.findById(id).orElseThrow(() -> new GeneralException("Student Does Not Exist", HttpStatus.NOT_FOUND));
	}

}
