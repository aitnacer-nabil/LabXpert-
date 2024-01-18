package com.aitnacer.LabXpert.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.TypeAnalyse}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeAnalyseDto implements Serializable {
    Long id;
    String nom;
    Long analyseId;
    List<Long> testIds;
    boolean deleted;
}