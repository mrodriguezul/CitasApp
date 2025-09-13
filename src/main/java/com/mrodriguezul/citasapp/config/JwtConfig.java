package com.mrodriguezul.citasapp.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;

@Component
public class JwtConfig {
    public String getSecretKey() {
        return "mkv2019*";
    }

    public Algorithm getJwtAlgorithm() {
        return Algorithm.HMAC256(this.getSecretKey());
    }

    public String createToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer("mrodriguezul.com")
                .withIssuedAt(Date.from(Instant.now()))
                .withExpiresAt(Date.from(Instant.now().plusSeconds(3600))) // 1 hour expiration
                .sign(getJwtAlgorithm());
    }

    public boolean isValid(String jwt) {
        try {
            JWT.require(getJwtAlgorithm())
                    .build()
                    .verify(jwt);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public String getUsername(String jwt) {
        return JWT.require(getJwtAlgorithm())
                .build()
                .verify(jwt)
                .getSubject();
    }
}
