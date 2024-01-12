package com.aitnacer.LabXpert.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Entity
@Table(name = "patients")
public class Patient extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    public Patient() {
        this.setRole(UserRole.PATIENT);
    }


    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private List<Echantillon> echantillons;

}
