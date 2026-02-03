package com.salesianostriana.dam.tarea2301.dto;

import com.salesianostriana.dam.tarea2301.model.EstadoVivienda;
import com.salesianostriana.dam.tarea2301.model.TipoVivienda;
import com.salesianostriana.dam.tarea2301.model.Vivienda;

import java.time.LocalDate;

public record ViviendaResponse(
        Long id,
        String titulo,
        String ciudad,
        String provincia,
        int precio,
        int metrosCuadrados,
        int habitaciones,
        int banos,
        TipoVivienda tipo,
        EstadoVivienda estado,
        boolean disponible,
        LocalDate fechaPublicacion
) {
    public ViviendaResponse viviendaResponse(Vivienda v){
        return new ViviendaResponse(
                v.getId(),
                v.getTitulo(),
                v.getCiudad(),
                v.getProvincia(),
                v.getPrecio(),
                v.getMCuadrados(),
                v.getHabitaciones(),
                v.getBanos(),
                v.getTipo(),
                v.getEstado(),
                v.isDisponible(),
                v.getFechaPublicacion()
                );
    }
}
//te kiero amiga <3