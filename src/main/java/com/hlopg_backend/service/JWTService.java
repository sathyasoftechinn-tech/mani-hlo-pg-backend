// package com.hlopg_backend.service;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Service;

// import javax.crypto.SecretKey;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Function;

// @Service
// public class JWTService {
    
//     @Value("${jwt.secret}")
//     private String secretKey;
    
//     @Value("${jwt.expiration}")
//     private long jwtExpiration;
    
//     private SecretKey getSigningKey() {
//         return Keys.hmacShaKeyFor(secretKey.getBytes());
//     }
    
//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }
    
//     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//         final Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }
    
//     private Claims extractAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(getSigningKey())
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
    
//     public String generateToken(UserDetails userDetails) {
//         return generateToken(new HashMap<>(), userDetails);
//     }
    
//     public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
//         return Jwts.builder()
//                 .setClaims(extraClaims)
//                 .setSubject(userDetails.getUsername())
//                 .setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
//                 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//                 .compact();
//     }
    
//     public boolean isTokenValid(String token, UserDetails userDetails) {
//         final String username = extractUsername(token);
//         return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
//     }
    
//     private boolean isTokenExpired(String token) {
//         return extractExpiration(token).before(new Date());
//     }
    
//     private Date extractExpiration(String token) {
//         return extractClaim(token, Claims::getExpiration);
//     }
// }

package com.hlopg_backend.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JWTService {
    
    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION_TIME = 86400000; // 24 hours
    
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }
    
    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    
    public boolean validateToken(String token, String email) {
        try {
            String extractedEmail = extractEmail(token);
            return extractedEmail.equals(email) && !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}