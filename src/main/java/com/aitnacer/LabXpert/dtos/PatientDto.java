package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.Patient;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Patient}
 */
@Value
public class PatientDto implements Serializable {
    Long id;
    String nom;
    String prenom;
    String Adresse;
    String telephone;
    EnumSexe sexe;
    boolean deleted;
}