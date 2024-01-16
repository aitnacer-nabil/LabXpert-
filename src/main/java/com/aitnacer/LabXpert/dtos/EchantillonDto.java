package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.Echantillon;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link Echantillon}
 */
@Value
public class EchantillonDto implements Serializable {
    LocalDateTime dateDeReception;
    String echantillonCode;
    PatientDto patient;
    UtilisateurDto Utilisateur;
    List<AnalyseDto> analyses;
    boolean deleted;
}