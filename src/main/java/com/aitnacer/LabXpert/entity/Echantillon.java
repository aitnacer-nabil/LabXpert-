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
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;


}
