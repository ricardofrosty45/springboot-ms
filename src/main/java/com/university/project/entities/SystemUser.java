package com.university.project.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.university.project.enums.Roles;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "system_user")
public class SystemUser {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private String id;
	@Column(name = "user_name", updatable = true, nullable = false)
	private String username;
	@Column(name = "password", updatable = true, nullable = false)
	private String password;
	@Column(name = "student_name", updatable = true, nullable = false)
	private String name;
	@Column(name = "type_of_graduation", updatable = true, nullable = true)
	private String typeOfGraduation;
	@Column(name = "birth_date", updatable = true, nullable = false)
	private Date birthDate;
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role", updatable = true, nullable = false)
	private Roles userRole;

}
