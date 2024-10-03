package com.security.mysecurity;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomAccesDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setContentType("application/Json");
		response.getWriter().write("Hey, YOU DO NOT HAVE PERMISSION TO ACCESS THIS RESOURCE");
	}

}
