package com.aitnacer.LabXpert.entity;

import lombok.*;

import javax.persistence.*;



@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Entity
@Table(name = "doctors")
public class Doctor extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    public Doctor() {
        this.setRole(UserRole.DOCTOR);
    }
    @OneToOne(mappedBy = "doctor")
    private Analyse analyse;
}
