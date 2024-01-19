package com.aitnacer.LabXpert.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TestStandardValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unite;
    private double minValue;
    private double maxValue;


    @OneToOne(mappedBy = "testStandardValue")
    private Test test;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;

    @Override
    public String toString() {
        return "TestStandardValue{" +
                "id=" + id +
                ", unite='" + unite + '\'' +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                '}';
    }
}
