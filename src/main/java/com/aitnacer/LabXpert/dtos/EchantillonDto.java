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
    Long patientId;
    PatientDto patient;
    Long utilisateurId;
    UtilisateurDto utilisateurDto;
    List<AnalyseDto> analyses;
    List<Long> analysesId;
    boolean deleted;
}