package com.university.project.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	@Column(name = "user_name", updatable = true, nullable = false)
	private String username;
	@Column(name = "student_name", updatable = true, nullable = false)
	private String name;
	@Column(name = "type_of_graduation", updatable = true, nullable = false)
	private String typeOfGraduation;
	@Column(name = "birth_date", updatable = true, nullable = false)
	private Date birthDate;

	public Student() {
	}

	public Student(String username, String name, String typeOfGraduation, Date birthDate) {
		this.username = username;
		this.name = name;
		this.typeOfGraduation = typeOfGraduation;
		this.birthDate = birthDate;
	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
