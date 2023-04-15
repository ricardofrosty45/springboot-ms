package com.university.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.project.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
}
