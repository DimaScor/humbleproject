package com.myproject.humbleproject.security.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.humbleproject.pojo.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException {
        String errorMessage = "Unauthorized";
        if (request.getRequestURI() != null) {
            errorMessage += " for " + request.getRequestURI();
        }
        response.setHeader("WWW-Authenticate", "Bearer realm=\"myrealm\"");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "Unauthorized",
                "You must be authenticated to access this resource");
        mapper.writeValue(response.getOutputStream(), errorResponse);
        // Log
        log.error(errorMessage, authException);
    }
}