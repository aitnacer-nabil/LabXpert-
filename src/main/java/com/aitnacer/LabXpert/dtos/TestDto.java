package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.dtos.ResultDto;
import com.aitnacer.LabXpert.dtos.TypeAnalyseDto;
import com.aitnacer.LabXpert.entity.Test;
import com.aitnacer.LabXpert.entity.TestStandardValue;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Test}
 */
@Value
public class TestDto implements Serializable {
    Long id;
    String nom;
    TypeAnalyseDto typeAnalyse;
    ResultDto result;
    TestStandardValue testStandardValue;
    boolean deleted;
}