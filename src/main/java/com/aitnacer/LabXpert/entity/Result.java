package com.aitnacer.LabXpert.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
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
