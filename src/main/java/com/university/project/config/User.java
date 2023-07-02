package com.university.project.config;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	private String email;
	private String name;
	private long issuer;
	private String role;
}
