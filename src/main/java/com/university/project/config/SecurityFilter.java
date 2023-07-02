package com.university.project.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.university.project.entities.SystemUser;
import com.university.project.repository.SystemUserRepository;
import com.university.project.util.JWTUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

	private List<String> whiteListEndpoints = List.of("/api/v1/login", "/api/v1/student");

	private List<String> whiteListMethods = List.of("POST");

	private JWTUtil jwtUtil = new JWTUtil();

	private final SystemUserRepository repo;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("ESTOU NO FILTRO!");
		this.verifyToken(request);
		filterChain.doFilter(request, response);

	}

	private void verifyToken(HttpServletRequest request) {
		String token = null;
		String authorization = request.getHeader("Authorization");
		if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
			token = authorization.substring(7);
		}

		if (token != null) {
			//jwtUtil.validateJwtToken(token);
			User securityUser = new User();
			DecodedJWT decodedJWT = JWT.decode(token);
			String role = decodedJWT.getClaim("ROLE").asString();
			String username = decodedJWT.getClaim("sub").asString();
			long iat = decodedJWT.getClaim("iat").asLong();

			SystemUser userDb = repo.findByUsername(username);

			securityUser.setEmail(username);
			securityUser.setName(userDb.getName());
			securityUser.setRole(role);
			securityUser.setIssuer(iat);
			List<GrantedAuthority> roleGrantedAuthority = new ArrayList<>();
			roleGrantedAuthority.add(new SimpleGrantedAuthority("ROLE_" + role));

			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUser,
					new Credentials(Credentials.CredentialType.ID_TOKEN, decodedJWT, token),roleGrantedAuthority);
			
			
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		if (whiteListEndpoints.contains(request.getRequestURI()) && whiteListMethods.contains(request.getMethod())) {
			return true;
		}

		return false;
	}

}
