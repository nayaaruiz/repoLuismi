package com.salesianostriana.nayat.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "art_festival",
            joinColumns = @JoinColumn(name = "artista_id"),
            inverseJoinColumns = @JoinColumn(name = "festival_id")
    )
    @Builder.Default //Si no lo establecemos en el builder, que lo haga directamente aquí
    private Set<Festival> festivales = new HashSet<>();

    /*
    ¿Los helpers son necesarios?
    En una relación bidireccional tu profe SÍ los quiere, porque:
    - Mantienen sincronizados los dos lados de la relación.
    - Evitan inconsistencias (que un festival tenga al artista pero el artista no al festival).
    */

    // Helpers festival

    public void addFestival(Festival festival) {
        festivales.add(festival);
        festival.getArtistas().add(this);
    }

    public void removeFestival(Festival festival) {
        festivales.remove(festival);
        festival.getArtistas().remove(this);
    }

}
