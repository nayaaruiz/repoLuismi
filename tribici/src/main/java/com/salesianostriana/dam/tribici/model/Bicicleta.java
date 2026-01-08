package com.salesianostriana.dam.tribici.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bicicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "estacion_id")
    private Estacion estacion;

    @OneToMany(mappedBy = "bicicleta")
    private List<Uso> usos;

}
