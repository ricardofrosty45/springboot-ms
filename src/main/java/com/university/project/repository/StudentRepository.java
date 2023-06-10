package com.university.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.university.project.entities.Student;


public interface StudentRepository extends JpaRepository<Student, String>{
	
	Student findByUsername(@Param("user_name")String username);
	
	
}
