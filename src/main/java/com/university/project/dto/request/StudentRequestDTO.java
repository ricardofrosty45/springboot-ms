package com.university.project.dto.request;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentRequestDTO {
	
	@NotBlank(message = "Username cannot be blank.")
	@Email(message = "Username has to be an valid email.")
	private String username;
	@NotBlank(message = "Username cannot be blank.")
	private String name;
	@NotBlank(message = "Username cannot be blank.")
	private String typeOfGraduation;
	@NotNull(message = "Please, inform a birthdate.")
	private Date birthDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeOfGraduation() {
		return typeOfGraduation;
	}

	public void setTypeOfGraduation(String typeOfGraduation) {
		this.typeOfGraduation = typeOfGraduation;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
