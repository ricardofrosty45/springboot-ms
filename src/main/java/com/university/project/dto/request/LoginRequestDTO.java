package com.university.project.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequestDTO {

	@NotBlank(message = "Username cannot be blank.")
	@Email(message = "Username has to be an valid email.")
	private String username;
	@NotBlank(message = "password cannot be blank.")
	private String password;
}
