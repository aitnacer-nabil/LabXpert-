package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.TestStandardValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link TestStandardValue}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestStandardValueDto implements Serializable {
    Long id;
    String unite;
    float minValue;
    float maxValue;
    TestDto test;
    boolean deleted;
}