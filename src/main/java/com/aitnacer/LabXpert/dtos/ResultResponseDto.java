package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.AnalyseStatus;
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
public class ResultResponseDto implements Serializable {
    Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime dateDebut;
    String Commentaire;
    AnalyseStatus status;
    String utilisateurNom;
    UserRole utilisateurRole;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime echantillonDateDeReception;
    String echantillonEchantillonCode;
    String analyseNom;
    List<ResultDto> results;
    boolean hasResult;

    /**
     * DTO for {@link com.aitnacer.LabXpert.entity.Result}
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ResultDto implements Serializable {
        Long id;
        String testNom;
        String testUnit;
        float testMinValue;
        float testMaxValue;
        float value;

    }
}