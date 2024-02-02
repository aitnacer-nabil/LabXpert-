package com.aitnacer.LabXpert.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "simple_analyse")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SimpleAnalyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateDebut;
    private String Commentaire;
    @Enumerated(EnumType.STRING)
    private AnalyseStatus status= AnalyseStatus.EN_ATTENTE;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Echantillon echantillon;
    @ManyToOne
    private Analyse analyse;
    @CreationTimestamp
    @Column(name = "simple_analyse_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "simple_analyse_updated_at")
    private LocalDateTime updatedAt;
    @OneToMany
    private List<Result> results= new ArrayList<>();
    @OneToMany
    private List<Reactif> reactifs  = new ArrayList<>();
    private boolean hasResult;
}
