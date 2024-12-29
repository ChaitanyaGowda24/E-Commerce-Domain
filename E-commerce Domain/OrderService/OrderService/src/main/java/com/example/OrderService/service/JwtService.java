package com.example.OrderService.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtService {

    private String secretKey = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437"; // Use a more secure secret key in production

    // Generate JWT token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Validate token
    public boolean validateToken(String token, String username) {
        String user = extractUsername(token);
        return (user.equals(username) && !isTokenExpired(token));
    }

    // Extract username from token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Check if token is expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extract expiration date from token
    private Date extractExpiration(String token) {
        return extractClaims(token).getExpiration();
    }

    // Extract claims from token
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}


