package com.leiton.ejercicioLogin.utils;

import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtils {

    private static final Algorithm ALGORITHM = Algorithm.HMAC256("secret");

    public static String createJwt(String email){
        try {
            return JWT.create()
                .withIssuer("JeremiasLeiton")
                .withClaim("email", email)
                .withJWTId(UUID.randomUUID().toString())
                .sign(ALGORITHM);
        } catch (JWTCreationException exception) {
            throw exception;
        }
    }

    public static void validateJwt(String token, String email){
        try {
            JWTVerifier verifier = JWT.require(ALGORITHM)
                .withIssuer("JeremiasLeiton")
                .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if (decodedJWT.getClaim("email").asString() != email) {
                throw new JWTVerificationException("JWT validation error");
            }
        } catch (JWTVerificationException exception) {
            throw exception;
        }
    }
}
