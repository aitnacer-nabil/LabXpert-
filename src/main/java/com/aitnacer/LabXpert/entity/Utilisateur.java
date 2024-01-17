package com.aitnacer.LabXpert.entity;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Objects;


@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "Utilisateur")
@NoArgsConstructor
public class Utilisateur extends UtilisateurInfo {

    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Builder
    public Utilisateur(Long id, String nom, String prenom, String Adresse, String telephone, EnumSexe sexe, boolean deleted, String userName, String password, UserRole role) {
        super(id, nom, prenom, Adresse, telephone, sexe, deleted);
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
