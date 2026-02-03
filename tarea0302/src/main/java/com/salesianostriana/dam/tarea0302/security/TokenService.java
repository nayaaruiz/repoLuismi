package com.salesianostriana.dam.tarea0302.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    //1. Una clave secreta para firmar (como el sello de la discoteca)
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // 2. Método para generar el Token (dar la pulsera)
    public String generarToken(String usuario) {
        return Jwts.builder()
                .setSubject(usuario) // a quién se lo mandas
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) //caduca en una hora
                .signWith(KEY) //Firmamos
                .compact();
    }

    // 3. Método para leer el usuario del Token (mirar pulsera)
    public String obtenerUsuarioDelToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e){
            return null; //Si el token es falso o ha caducado
        }
    }

}