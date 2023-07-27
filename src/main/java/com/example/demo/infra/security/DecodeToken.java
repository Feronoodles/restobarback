package com.example.demo.infra.security;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class DecodeToken {

    public String[] decodeToken(String JWTtoken)
    {
        String[] usuarioDecode = new String[2];

        String[] parts = JWTtoken.split("\\."); // split out the "parts" (header, payload and signature)

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String payloadJson = new String(decoder.decode(parts[1]));
        //String signatureJson = new String(decoder.decode(parts[2]));

        String[] bodyParts = payloadJson.replace('}',' ').trim().split(",");
        usuarioDecode[0]= returnCorreo(bodyParts[3]);
        usuarioDecode[1]= returnUsuarioId(bodyParts[0]);
        return usuarioDecode;
    }
    public String returnCorreo(String correo)
    {
        String[] correoArreglado = correo.split(":");
        return correoArreglado[1];
    }
    public String returnUsuarioId(String id)
    {
        String[] usuarioIdArreglado = id.split(":");
        return usuarioIdArreglado[1];
    }
}
