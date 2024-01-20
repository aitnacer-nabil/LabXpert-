package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.Test;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO for {@link Test}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDto implements Serializable {
    @NotNull
    Long id;
    @NotNull
    @NotEmpty
    @Min(2)
    String nom;
    String unit;
    @Min(value = 0, message = "Minimum value must be greater than or equal to 0")
    float minValue;
    @Min(value = 0, message = "Maximum value must be greater than or equal to 0")
    float maxValue;
    TypeAnalyseDto typeAnalyse;
}