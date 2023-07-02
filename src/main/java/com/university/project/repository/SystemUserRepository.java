package com.university.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.university.project.entities.SystemUser;


public interface SystemUserRepository extends JpaRepository<SystemUser, String>{
	
	SystemUser findByUsername(@Param("user_name")String username);
	
	
}
