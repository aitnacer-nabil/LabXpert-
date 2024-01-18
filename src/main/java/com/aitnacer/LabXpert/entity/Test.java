package com.aitnacer.LabXpert.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "test")
@Data
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    private TypeAnalyse typeAnalyse;


    private float result;
    @OneToOne
    private TestStandardValue testStandardValue;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;
    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
