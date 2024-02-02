package com.aitnacer.LabXpert.dtos.scheduling;

import com.aitnacer.LabXpert.entity.AnalyseStatus;
import com.aitnacer.LabXpert.entity.Reactif;
import com.aitnacer.LabXpert.entity.Result;
import com.aitnacer.LabXpert.entity.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class SchedulingResponseDto implements Serializable {
    Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime dateDebut;
    String Commentaire;
    AnalyseStatus status;

    Long echantillonId;
    String echantillonEchantillonCode;
    Long utilisateurId;
    String utilisateurNom;
    UserRole utilisateurRole;
    Long analyseId;
    String analyseNom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime updatedAt;
    List<Result> results;
    boolean hasResult;
}