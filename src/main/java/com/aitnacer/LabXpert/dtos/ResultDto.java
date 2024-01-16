package com.aitnacer.LabXpert.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Result}
 */
@Value
public class ResultDto implements Serializable {
    Long id;
    float value;
    boolean deleted;
}