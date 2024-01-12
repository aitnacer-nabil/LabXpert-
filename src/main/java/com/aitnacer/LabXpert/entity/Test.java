package com.aitnacer.LabXpert.entity;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    private TypeAnalyse typeAnalyse;

    @OneToOne
    private Result result;
    @OneToOne
    private TestStandardValue testStandardValue;

}
