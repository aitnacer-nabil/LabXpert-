package com.aitnacer.LabXpert.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="reactifs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reactif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReactif;
    private String nom;
    private String description;
    private int quantite;
    private LocalDateTime dateExpiration;
    @ManyToOne
    private Fournisseur fournisseur;
    @Column(name="is_deleted")
    private boolean deleted;


}