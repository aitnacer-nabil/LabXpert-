package com.aitnacer.LabXpert.dtos.reactif;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.ReactifAnalyse}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactifAnalyseDto implements Serializable {
    Long id;
    private Long reactifIdReactif;
    int quantite;
}