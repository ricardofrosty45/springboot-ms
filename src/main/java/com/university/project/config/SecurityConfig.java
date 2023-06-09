package com.university.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig {

	private final SecurityFilter filter;

	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests((requests) -> requests
				.antMatchers(HttpMethod.POST,"/api/v1/login").permitAll()
				.antMatchers(HttpMethod.POST,"/api/v1/student").permitAll()
				.and()
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class))
				.formLogin((formLogin) -> formLogin.disable()).csrf((csrf) -> csrf.disable()).build();
	}

}
