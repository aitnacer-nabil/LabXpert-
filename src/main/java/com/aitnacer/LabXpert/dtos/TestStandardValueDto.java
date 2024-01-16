package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.dtos.TestDto;
import com.aitnacer.LabXpert.entity.TestStandardValue;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link TestStandardValue}
 */
@Value
public class TestStandardValueDto implements Serializable {
    Long id;
    String unite;
    float minValue;
    float maxValue;
    TestDto test;
    boolean deleted;
}