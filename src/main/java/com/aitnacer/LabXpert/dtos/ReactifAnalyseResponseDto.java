package com.aitnacer.LabXpert.dtos;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.ReactifAnalyse}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactifAnalyseResponseDto implements Serializable {
    Long id;
    Long reactifIdReactif;
    int quantite;
}