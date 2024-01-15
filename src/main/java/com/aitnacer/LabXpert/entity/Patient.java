package com.aitnacer.LabXpert.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Data
@ToString(callSuper = true)
@Entity
@Table(name = "patients")
@NoArgsConstructor
public class Patient extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private List<Echantillon> echantillons;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id + super.toString() +
                '}';
    }
}
