package com.dent.web.jwt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.Serializable;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "message: Unauthorized actions");
    }

    public ResponseEntity<String> badCredentialsExceptionHandler(HttpServletRequest request, HttpServletResponse response, BadCredentialsException ex) throws IOException {
        return ResponseEntity.status(BAD_REQUEST).body("Bad Credentials Exception.");
    }
}