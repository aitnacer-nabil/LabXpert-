package com.aitnacer.LabXpert.entity;

import javax.persistence.*;

@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float result;


    @ManyToOne
    @JoinColumn(name = "simple_analyse_id")
    private SimpleAnalyse simpleAnalyse;
}
