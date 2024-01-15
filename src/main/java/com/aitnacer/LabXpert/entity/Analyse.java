package com.aitnacer.LabXpert.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "analysis")
@Data
@NoArgsConstructor
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateDebut;
    private String Commentaire;
    private String nom;
    @ManyToOne
    private Echantillon echantillon;
    @Enumerated(EnumType.STRING)
    private AnalyseStatus status;

    @OneToMany(mappedBy = "analyse",fetch = FetchType.EAGER)
    private List<TypeAnalyse> typeAnalyses;
    @OneToOne
    private Utilisateur utilisateur;

    @Override
    public String toString() {
        return "Analyse{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", Commentaire='" + Commentaire + '\'' +
                ", nom='" + nom + '\'' +
                ", status=" + status +
                '}';
    }
}
