package com.university.project.exceptions;

import org.springframework.http.HttpStatus;

public class GeneralException extends RuntimeException {

	private HttpStatus status;

	private int statusCode;

	public GeneralException(String message, HttpStatus status) {
		super(String.format(message));
		this.statusCode = status.value();
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
