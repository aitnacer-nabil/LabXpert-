package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.AnalyseStatus;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Analyse}
 */
@Value
public class AnalyseDto implements Serializable {
    Long id;
    LocalDateTime dateDebut;
    String Commentaire;
    String nom;
    Long echantillonId;
    AnalyseStatus status;
    List<Long> typeAnalysisIds;
    Long doctorId;
}