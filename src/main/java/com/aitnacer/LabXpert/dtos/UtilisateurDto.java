package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.UserRole;
import com.aitnacer.LabXpert.entity.Utilisateur;
import lombok.*;

import javax.validation.constraints.*;
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
    @NotNull(message = "The prenom should not be null!")
    String prenom;
    @Size(min = 5)
    @NotNull(message = "The adress should not be null!")
    String Adresse;
    @NotNull(message = "The telephone should not be null!")
    @Min(10) @Max(10)
    String telephone;
    @NotNull
    EnumSexe sexe;
    boolean deleted;
    @NotNull(message = "The userName should not be null!")
    @NotBlank(message = "The password should not be blank!")
    String userName;
    @NotNull(message = "The password should not be null!")
    @NotBlank(message = "The password should not be blank!")
    String password;
    @NotNull
    UserRole role;
}