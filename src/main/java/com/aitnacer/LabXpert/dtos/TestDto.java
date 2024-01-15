package com.aitnacer.LabXpert.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Test}
 */
@Value
public class TestDto implements Serializable {
    Long id;
    String nom;
    Long typeAnalyseId;
    Long resultId;
    Long testStandardValueId;
}