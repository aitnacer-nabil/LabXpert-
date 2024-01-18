package com.aitnacer.LabXpert.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Test}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDto implements Serializable {
    Long id;
    String nom;
    TypeAnalyseDto typeAnalyse;
    float result;
    TestStandardValueDto testStandardValue;
    boolean deleted;
}