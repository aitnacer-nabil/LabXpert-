package com.aitnacer.LabXpert.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.ReactifAnalyse}
 */
@Value
public class ReactifAnalyseDto implements Serializable {
    Long id;
    Long reactifIdReactif;
    int quantite;
}