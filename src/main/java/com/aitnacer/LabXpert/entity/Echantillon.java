package com.aitnacer.LabXpert.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "echantillons")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Echantillon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateDeReception;
    private String echantillonCode;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Utilisateur utilisateur;
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
    @PrePersist
    private void prePersist() {
        if (patient != null) {
            if (patient.getEchantillons() == null) {
                patient.setEchantillons(new ArrayList<>());
            }
            patient.getEchantillons().add(this);
        }
        if (utilisateur != null){
            if(utilisateur.getEchantillons() == null ){
                utilisateur.setEchantillons(new ArrayList<>());
            }
            utilisateur.getEchantillons().add(this);
        }
    }
}
