package com.aitnacer.LabXpert.dtos.analyse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestRequestDto{
    @NotNull(message = "Name cannot be null")
    @Size(message = "Name must be between 1 and 255 characters", min = 1, max = 255)
    String nom;
    @NotNull(message = "unit value cannot be null")
    String unit;
    @Min(value = 0, message = "Minimum value must be greater than or equal to 0")
    float minValue;
    @Min(value = 0, message = "Maximum value must be greater than or equal to 0")
    float maxValue;

}
