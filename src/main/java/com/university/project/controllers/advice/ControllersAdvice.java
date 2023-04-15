package com.university.project.controllers.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.university.project.dto.response.GenericResponse;
import com.university.project.exceptions.GeneralException;

@ControllerAdvice
public class ControllersAdvice extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new GenericResponse(ex.getFieldError().getDefaultMessage(), status.value()),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<GenericResponse> generalException(GeneralException ex) {
		return new ResponseEntity<GenericResponse>(new GenericResponse(ex.getMessage(), ex.getStatusCode()),
				ex.getStatus());
	}

}
