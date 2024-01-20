package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.EnumSexe;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Patient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto implements Serializable {
    Long id;
    String nom;
    String prenom;
    String Adresse;
    String telephone;
    EnumSexe sexe;
    boolean deleted;

}