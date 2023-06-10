package com.university.project.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class SecurityFilter extends OncePerRequestFilter {

	private List<String> whiteListEndpoints = List.of("/api/v1/login", "/api/v1/student");

	private List<String> whiteListMethods = List.of("POST");

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("ESTOU NO FILTRO!");
		filterChain.doFilter(request, response);

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		if (whiteListEndpoints.contains(request.getRequestURI()) && whiteListMethods.contains(request.getMethod())) {
			return true;
		}

		return false;
	}

}
