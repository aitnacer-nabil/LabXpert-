package com.aitnacer.LabXpert.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.TypeAnalyse}
 */
@Value
public class TypeAnalyseDto implements Serializable {
    Long id;
    String nom;
    Long analyseId;
    List<Long> testIds;
    boolean deleted;
}