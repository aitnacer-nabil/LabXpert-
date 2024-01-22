package com.aitnacer.LabXpert.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.ReactifAnalyse}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactifAnalyseDto implements Serializable {
    Long id;
    Long reactifIdReactif;
    String reactifNom;
    String reactifDescription;
    int reactifQuantite;
    LocalDateTime reactifDateExpiration;
    Boolean reactifDeleted;
    int quantite;
}