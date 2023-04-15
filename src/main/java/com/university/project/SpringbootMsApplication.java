package com.university.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.university.project.entities" })
@EnableJpaRepositories(basePackages = {"com.university.project.repository"})
public class SpringbootMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMsApplication.class, args);
	}

}
