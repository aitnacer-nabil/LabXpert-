package com.aitnacer.LabXpert.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "utilisateurs")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
public abstract class UtilisateurInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "The name should not be null!")
    @Size(min = 5)
    @NotEmpty
    private String nom;
    @NotNull(message = "The prenom should not be null!")
    @Size(min = 5)
    @NotEmpty
    private String prenom;
    @NotNull(message = "The Adresse should not be null!")
    @Size(min = 5)
    @NotEmpty
    private String Adresse;
    @NotNull(message = "The prenom should not be null!")
    @Size(min = 10,max = 10)
    @NotEmpty
    private String telephone;
    @Enumerated(EnumType.STRING)
    @NotNull
    @NotEmpty
    private EnumSexe sexe;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;


}
