package com.aitnacer.LabXpert.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeAnalyse")
public class TypeAnalyse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Analyse analyse;
    @OneToMany(mappedBy = "typeAnalyse")
    private List<Test> tests;
}
