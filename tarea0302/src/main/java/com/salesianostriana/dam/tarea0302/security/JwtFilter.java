package com.salesianostriana.dam.tarea0302.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    @Override
    protected void doFIlterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
        throws ServletException, IOException {

        // 1. Buscamos el header "Authorization"
        String authHeader = request.getHeader("Authorization");

        // 2. Si hay header y empieza por "Bearer", sacamos el token
        if (authHeader != null && authHeader.startsWith("Bearer")) {
            // Quitamos la palabra "Bearer"
            String token = authHeader.substring(7);
            String username = tokenService.obtenerUsuarioDelToken(token);

            // 3. Si el token válido, le decimos a Spring: "Este usuario está logueado"
            if (username != null) {
                UsernamePasswordAuthenticationToken autenticacion =
                        new UsernamePasswordAuthenticationToken(
                                username, null, new ArrayList<>()
                        );
                autenticacion.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(autenticacion);
            }
        }

        // 4. Continuar con la petición
        filterChain.doFilter(request, response);

    }

}
