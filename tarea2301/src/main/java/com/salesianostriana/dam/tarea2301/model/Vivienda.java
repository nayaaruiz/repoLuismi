package com.salesianostriana.dam.tarea2301.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString
public class Vivienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String ciudad;
    private String provincia;
    private int precio;
    private int mCuadrados;
    private int habitaciones;
    private int banos;

    @Enumerated(EnumType.STRING)
    private TipoVivienda tipo;

    @Enumerated(EnumType.STRING)
    private EstadoVivienda estado;

    private boolean ascensor;
    private boolean terraza;
    private boolean garaje;
    private boolean disponible;

    private LocalDate fechaPublicacion;

}
