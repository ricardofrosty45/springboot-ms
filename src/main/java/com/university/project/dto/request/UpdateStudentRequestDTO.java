package com.university.project.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UpdateStudentRequestDTO {
	@NotBlank(message = "studentId cannot be blank.")
	private String studentId;
	@NotBlank(message = "address cannot be blank.")
	private String address;
	@NotBlank(message = "cellphoneNumber cannot be blank.")
    private String cellphoneNumber;
}
