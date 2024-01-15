package com.aitnacer.LabXpert.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "utilisateurs")
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur {
    private String nom;
    private String prenom;
    private String Adresse;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private EnumSexe sexe;
    @Getter
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;
    public Utilisateur() {
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", Adresse='" + Adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", sexe=" + sexe +
                ", role=" + role +
                ", id=" + id +
                '}';
    }
}
