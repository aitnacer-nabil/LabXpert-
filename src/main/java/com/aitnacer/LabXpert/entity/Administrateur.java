package com.aitnacer.LabXpert.entity;

import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Entity
@Table(name = "administrateurs")
public class Administrateur extends Utilisateur {

    private String userName;
    private String password;

    public Administrateur() {
        this.setRole(UserRole.RESPONSABLE);
    }


}
