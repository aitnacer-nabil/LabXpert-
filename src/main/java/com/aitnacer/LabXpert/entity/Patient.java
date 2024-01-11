package com.aitnacer.LabXpert.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String Adresse;
    private String telephone;
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private Set<Echantillon> echantillons = new HashSet<>();

}
