package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.Administrateur;
import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Administrateur}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministrateurDto implements Serializable {
    String nom;
    String prenom;
    String Adresse;
    String telephone;
    EnumSexe sexe;
    UserRole role;
    Long id;
    String userName;
    String password;
}