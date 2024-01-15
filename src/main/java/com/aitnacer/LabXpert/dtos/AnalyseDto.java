package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.AnalyseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Analyse}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyseDto implements Serializable {
    Long id;
    LocalDateTime dateDebut;
    String Commentaire;
    String nom;
    Long echantillonId;
    AnalyseStatus status;
    List<Long> typeAnalysisIds;
    Long utilisateurId;
}