package com.myproject.humbleproject.security.token;

import com.myproject.humbleproject.security.CustomUserDetailsService;
import com.myproject.humbleproject.security.token.JwtProvider;
import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Value("${jwt.secret}")
    private final String jwtSecret;



    public JwtAuthenticationFilter(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7);

            try {
                Jws<Claims> claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken);
                String username = claims.getBody().getSubject();

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                    if (JwtProvider.validateToken(jwtToken, userDetails.getUsername(), jwtSecret)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities()
                        );
                        authentication.setDetails(
                                new WebAuthenticationDetailsSource().buildDetails((javax.servlet.http.HttpServletRequest) request)
                        );
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } catch (ExpiredJwtException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {
                logger.error("JWT token validation failed: " + e.getMessage());
            }
        }

        chain.doFilter(request, response);
    }
}
