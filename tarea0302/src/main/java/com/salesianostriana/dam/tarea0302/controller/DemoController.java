package com.salesianostriana.dam.tarea0302.controller;

import com.salesianostriana.dam.tarea0302.security.LoginRequest;
import com.salesianostriana.dam.tarea0302.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final TokenService tokenService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        //Simulamos comprobación de usuario y contraseña
        if ("alumno".equals(request.getUsuario()) && "1234".equals(request.getPassword())){
            return tokenService.generarToken(request.getUsuario());
        }
        throw new RuntimeException("Usuario o contraseña incorrectos");
    }

    @GetMapping("/publico")
    public String endpointPublico() {
        return "Soy un endpoint público";
    }

    @GetMapping("/privado")
    public String endpointPrivado() {
        return "¡Soy un endpoint público!";
    }

}