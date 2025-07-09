package com.example.EvidencijaPolaznika.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Polaznik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ime je obavezno")
    private String ime;

    @NotBlank(message = "Prezime je obavezno")
    private String prezime;

    @OneToMany(mappedBy = "polaznik", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Upis> upisi = new HashSet<>();
}
