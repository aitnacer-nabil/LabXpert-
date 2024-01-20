package com.aitnacer.LabXpert.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "analysis")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;
    @OneToMany
    List<TypeAnalyse> typeAnalyses;
    @ManyToOne
    @JoinColumn(name = "simple_analyse_id")
    private SimpleAnalyse simpleAnalyse;
}
