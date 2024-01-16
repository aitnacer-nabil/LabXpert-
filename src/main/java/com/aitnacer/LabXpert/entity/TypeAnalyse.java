package com.aitnacer.LabXpert.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeAnalyse")
@Data
public class TypeAnalyse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    private Analyse analyse;
    @OneToMany(mappedBy = "typeAnalyse")
    private List<Test> tests;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;
    @Override
    public String toString() {
        return "TypeAnalyse{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
