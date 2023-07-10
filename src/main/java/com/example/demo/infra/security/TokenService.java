/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.Usuario;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class TokenService {
    @Value("{api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario)
    {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("restobar")
                    .withSubject(usuario.getCorreo())
                    .withClaim("usuarioId",usuario.getid())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        }catch (JWTCreationException exception)
        {
            throw  new RuntimeException();
        }


    }
    public String getSubject(String token)
    {
        if(token == null)
        {
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("restobar")
                    .build()
                    .verify(token);
            verifier.getSubject();
        }catch (JWTVerificationException exception)
        {
            System.out.println(exception.toString());
        }
        if(verifier.getSubject() == null)
        {
            throw new RuntimeException("VERIFIER INVALIDO");
        }
        return verifier.getSubject();
    }

    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
