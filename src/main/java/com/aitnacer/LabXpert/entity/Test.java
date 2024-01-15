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

    @OneToOne
    private Result result;
    @OneToOne
    private TestStandardValue testStandardValue;

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
