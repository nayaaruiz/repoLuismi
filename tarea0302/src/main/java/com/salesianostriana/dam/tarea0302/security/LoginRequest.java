package com.salesianostriana.dam.tarea0302.security;

import lombok.Data;

@Data
public class LoginRequest {
    private String usuario;
    private String password;
}