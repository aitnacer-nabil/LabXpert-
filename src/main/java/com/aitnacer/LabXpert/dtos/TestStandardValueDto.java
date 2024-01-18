package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.TestStandardValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link TestStandardValue}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestStandardValueDto implements Serializable {
    Long id;
    String unite;
    float minValue;
    float maxValue;
    TestDto test;
    long testId;
    boolean deleted;
}