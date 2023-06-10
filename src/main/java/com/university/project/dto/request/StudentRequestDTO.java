package com.university.project.dto.request;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class StudentRequestDTO {
	@NotBlank(message = "Username cannot be blank.")
	@Email(message = "Username has to be an valid email.")
	private String username;
	@NotBlank(message = "password cannot be blank.")
	private String password;
	@NotBlank(message = "Username cannot be blank.")
	private String name;
	@NotBlank(message = "Username cannot be blank.")
	private String typeOfGraduation;
	@NotNull(message = "Please, inform a birthdate.")
	private Date birthDate;
	@NotBlank(message = "address cannot be blank.")
	private String address;
	@NotBlank(message = "cellphoneNumber cannot be blank.")
    private String cellphoneNumber;
}
