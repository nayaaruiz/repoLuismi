package com.salesianostriana.nayat.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ciudad;

    @ManyToMany(mappedBy = "festivales")
    @Builder.Default //Si no lo establecemos en el builder, que lo haga directamente aquí
    @ToString.Exclude //Romper recursión infinita
    private Set<Artista> artistas = new HashSet<>();

    // Helpers artista

    public void addArtista(Artista artista) {
        artistas.add(artista);
        artista.getFestivales().add(this);
    }

    public void removeArtista(Artista artista) {
        artistas.remove(artista);
        artista.getFestivales().remove(this);
    }

}
