package com.example.EvidencijaPolaznika.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Upis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_id")
    private ProgramObrazovanja program;

    @ManyToOne(optional = false)
    @JoinColumn(name = "polaznik_id")
    private Polaznik polaznik;
}
