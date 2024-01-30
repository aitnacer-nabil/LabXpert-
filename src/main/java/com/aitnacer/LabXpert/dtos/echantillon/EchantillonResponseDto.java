package com.aitnacer.LabXpert.dtos.echantillon;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Echantillon}
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EchantillonResponseDto implements Serializable {
    Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime dateDeReception;
    String echantillonCode;
    String patientNom;
    String utilisateurNom;
    boolean assigned;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime updatedAt;
    List<ReactifAnalyseDto> reactifAnalyses;


}
/**
 * DTO for {@link com.aitnacer.LabXpert.entity.ReactifAnalyse}
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
 class ReactifAnalyseDto implements Serializable {
    Long id;
    String reactifNom;
    int quantite;
}