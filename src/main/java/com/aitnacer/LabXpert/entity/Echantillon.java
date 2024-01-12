package com.aitnacer.LabXpert.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "echantillons")
@Data
public class Echantillon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateDeReception;
    private String echantillonCode;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Technicien techenicien;
    @OneToMany(mappedBy = "echantillon",fetch = FetchType.EAGER)
    private List<Analyse> analyses;

    @Override
    public String toString() {
        return "Echantillon{" +
                "id=" + id +
                ", dateDeReception=" + dateDeReception +
                ", echantillonCode='" + echantillonCode + '\'' +
                '}';
    }
}
