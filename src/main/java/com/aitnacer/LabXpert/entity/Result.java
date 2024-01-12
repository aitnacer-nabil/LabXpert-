package com.aitnacer.LabXpert.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float value;

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
