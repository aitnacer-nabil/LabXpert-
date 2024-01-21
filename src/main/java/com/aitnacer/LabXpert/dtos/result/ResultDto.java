package com.aitnacer.LabXpert.dtos.result;

import lombok.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Result}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDto implements Serializable {
    Long id;
    @NotNull(message = "Test ID cannot be null")
    Long testId;
    @Positive(message = "Value must be a positive number")
    @DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than 0.0")
    float value;
}