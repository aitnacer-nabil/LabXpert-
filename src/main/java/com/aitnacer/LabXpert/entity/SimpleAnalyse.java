package com.aitnacer.LabXpert.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "simple_analyse")
public class SimpleAnalyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateDebut;
    private String Commentaire;
    private String nom;
    @Enumerated(EnumType.STRING)
    private AnalyseStatus status;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Echantillon echantillon;
    @ManyToOne
    private Analyse analyse;


}
