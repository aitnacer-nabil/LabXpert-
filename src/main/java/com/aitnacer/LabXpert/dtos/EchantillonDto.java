package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.Echantillon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link Echantillon}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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