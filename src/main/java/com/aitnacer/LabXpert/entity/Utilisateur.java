package com.aitnacer.LabXpert.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "Utilisateur")
@NoArgsConstructor
public class Utilisateur extends UtilisateurInfo {
    @NotNull(message = "The username should not be null!")
    private String userName;
    @NotNull(message = "The password should not be null!")
    @NotBlank(message = "The password should not be blank!")
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public Utilisateur(Long id, String nom, String prenom, String Adresse, String telephone, EnumSexe sexe, boolean deleted, String userName, String password, UserRole role) {

    }
}
