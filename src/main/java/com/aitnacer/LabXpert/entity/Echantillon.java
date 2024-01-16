package com.aitnacer.LabXpert.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "echantillons")
@Data
@NoArgsConstructor
public class Echantillon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateDeReception;
    private String echantillonCode;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Utilisateur Utilisateur;
    @OneToMany(mappedBy = "echantillon",fetch = FetchType.EAGER)
    private List<Analyse> analyses;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;
    @Override
    public String toString() {
        return "Echantillon{" +
                "id=" + id +
                ", dateDeReception=" + dateDeReception +
                ", echantillonCode='" + echantillonCode + '\'' +
                '}';
    }
}
