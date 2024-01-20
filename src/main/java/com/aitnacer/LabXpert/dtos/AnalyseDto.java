package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.SimpleAnalyse;
import com.aitnacer.LabXpert.entity.TypeAnalyse;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Analyse}
 */
@Value
public class AnalyseDto implements Serializable {
    Long id;
    String nom;
    boolean deleted;
    List<TypeAnalyse> typeAnalyses;
    SimpleAnalyse simpleAnalyse;
}