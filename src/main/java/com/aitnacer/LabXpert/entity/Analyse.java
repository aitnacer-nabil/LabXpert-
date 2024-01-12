package com.aitnacer.LabXpert.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "analysis")
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateDebut;
    private String Commentaire;
    @ManyToOne
    private Echantillon echantillon;
    @Enumerated(EnumType.STRING)
    private AnalyseStatus status;

    @OneToMany(mappedBy = "analyse",fetch = FetchType.EAGER)
    private List<TypeAnalyse> typeAnalyses;
    @OneToOne
    private Doctor doctor;

}
