package com.aitnacer.LabXpert.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="fournisseurs", uniqueConstraints = {@UniqueConstraint(name = "nom_unique", columnNames = {"nom"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;
    @Column(name = "nom",unique = true)
    private String nom;
    private String adresse;
    private String tel;
    @Column(name="is_deleted")
    private boolean deleted;

}