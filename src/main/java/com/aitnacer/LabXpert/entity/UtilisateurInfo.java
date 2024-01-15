package com.aitnacer.LabXpert.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "utilisateurs")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UtilisateurInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String Adresse;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private EnumSexe sexe;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;


}
