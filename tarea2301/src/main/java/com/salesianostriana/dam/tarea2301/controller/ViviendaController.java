package com.salesianostriana.dam.tarea2301.controller;

import com.salesianostriana.dam.tarea2301.model.Vivienda;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViviendaController {

    @GetMapping("/api/v1/viviendas")
    public ResponseEntity<Page<Vivienda>> obtenerVieviendas(){
        return
    }

}
