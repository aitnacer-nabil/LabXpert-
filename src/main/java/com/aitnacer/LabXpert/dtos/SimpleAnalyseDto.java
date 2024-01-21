package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.dtos.echantillon.EchantillonDto;
import com.aitnacer.LabXpert.dtos.result.ResultDto;
import com.aitnacer.LabXpert.entity.AnalyseStatus;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.SimpleAnalyse}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleAnalyseDto implements Serializable {
    Long id;
    LocalDateTime dateDebut;
    String Commentaire;
    AnalyseStatus status;
    UtilisateurDto utilisateur;
    EchantillonDto echantillon;
    AnalyseDto analyse;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    List<ResultDto> results;
}