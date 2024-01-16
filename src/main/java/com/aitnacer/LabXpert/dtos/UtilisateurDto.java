package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.UserRole;
import com.aitnacer.LabXpert.entity.Utilisateur;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Utilisateur}
 */
@Value
public class UtilisateurDto implements Serializable {
    Long id;
    String nom;
    String prenom;
    String Adresse;
    String telephone;
    EnumSexe sexe;
    boolean deleted;
    String userName;
    String password;
    UserRole role;
}