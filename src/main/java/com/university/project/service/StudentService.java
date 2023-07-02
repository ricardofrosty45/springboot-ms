package com.university.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.university.project.dto.request.StudentRequestDTO;
import com.university.project.dto.response.GenericResponse;
import com.university.project.entities.SystemUser;
import com.university.project.enums.Roles;
import com.university.project.exceptions.GeneralException;
import com.university.project.repository.SystemUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class StudentService {

	private final SystemUserRepository repository;

	public GenericResponse registerNewStudentIntoUniversity(StudentRequestDTO request) {
		Optional.ofNullable(repository.findByUsername(request.getUsername())).ifPresentOrElse(student -> {
			log.error("Student already exist");
			throw new GeneralException("Student already exist", HttpStatus.CONFLICT);
		}, () -> {
			log.info("Creating students . . .");
			SystemUser entity = new SystemUser();
			entity.setUserRole(Roles.STUDENT);
			BeanUtils.copyProperties(request, entity);
			repository.save(entity);
			log.info("Student Created!");
		});
		return new GenericResponse("Student Created!", 201);
	}

	public List<SystemUser> listAllStudents() {
		return repository.findAll();
	}

	public SystemUser getStudentById(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new GeneralException("Student Does Not Exist", HttpStatus.NOT_FOUND));
	}

}
