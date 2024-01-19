package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.Result;
import com.aitnacer.LabXpert.entity.TestStandardValue;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Test}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDto implements Serializable {
    Long id;
    String nom;
    Long typeAnalyseId;
    double resultResult;
    Long testStandardValueId;
    boolean deleted;
    Result result;
//TestStandardValue testStandardValue;
}