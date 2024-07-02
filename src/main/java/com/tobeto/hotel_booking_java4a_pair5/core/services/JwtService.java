package com.tobeto.hotel_booking_java4a_pair5.core.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    @Value("${jwt.expiration}")
    private long EXPIRATION;

    @Value("${jwt.key}")
    private String SECRET_KEY;

    public String createToken(String username, Map<String, Object> extraClaims) {
        return Jwts
                .builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .claims(extraClaims)
                .subject(username)
                .signWith(getSignKey())
                .compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUser(token);
        Date expirationDate = extractExpiration(token);

        return userDetails.getUsername().equals(username) && !expirationDate.before(new Date());
    }

    public Date extractExpiration(String token) {
        SecretKey key = (SecretKey) getSignKey();

        Claims claims = Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getExpiration();
    }

    public String extractUser(String token) {
        SecretKey key = (SecretKey) getSignKey();

        Claims claims = Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public String extractUsername(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    private Claims getClaimsFromToken(String token) {
        SecretKey key = (SecretKey) getSignKey();

        return Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
