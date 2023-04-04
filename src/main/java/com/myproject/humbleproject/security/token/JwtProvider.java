package com.myproject.humbleproject.security.token;

import com.myproject.humbleproject.exceptions.JwtAuthenticationException;
import com.sun.security.auth.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;

@Service
public class JwtProvider {

    private JwtProvider(){}
    public static String generateToken(UserDetails userDetails, String jwtSecret, int jwtExpirationMs) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret)))
                .compact();
    }

    public static String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public static boolean validateToken(String token,String username, String jwtSecret) {
        try {
            String tokenName = getUsernameFromToken(token, jwtSecret);
            if(!username.equals(tokenName)){
                throw new JwtAuthenticationException("Jwt does not exist", HttpStatus.UNAUTHORIZED);
            }

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtAuthenticationException("JWT token is expired or invalid", HttpStatus.UNAUTHORIZED);
        }
    }

    public static String getUsernameFromToken(String token, String jwtSecret){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret)))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

}

