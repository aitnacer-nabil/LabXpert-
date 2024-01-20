package com.aitnacer.LabXpert.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String unit;
    private float minValue;
    private float maxValue;
    @ManyToOne
    @JoinColumn(name = "type_analyse_id")
    private TypeAnalyse typeAnalyse;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;

}
