package com.aitnacer.LabXpert.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Planification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "planification",fetch = FetchType.EAGER)
    private List<Analyse> analyses;



}
