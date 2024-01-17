package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.UserRole;
import com.aitnacer.LabXpert.entity.Utilisateur;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link Utilisateur}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateurDto implements Serializable {
    Long id;
    @NotNull(message = "The nom should not be null!")
    String nom;
    String prenom;
    @Size(min = 5)
    String Adresse;
    String telephone;
    EnumSexe sexe;
    boolean deleted;
    String userName;
    String password;
    UserRole role;
}