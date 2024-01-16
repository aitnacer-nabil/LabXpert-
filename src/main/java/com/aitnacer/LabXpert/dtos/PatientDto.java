package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Patient}
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto implements Serializable {
    Long id;
    String nom;
    String prenom;
    String Adresse;
    String telephone;
    EnumSexe sexe;
    boolean deleted;
}