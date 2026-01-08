package com.salesianostriana.pokemon;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private int nivel;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

}
