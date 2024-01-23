package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.Test;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Test}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestDto implements Serializable {
    Long id;
    @NotNull(message = "Name cannot be null")
    @Size(message = "Name must be between 1 and 255 characters", min = 1, max = 255)
    String nom;
    @NotNull(message = "unit value cannot be null")
    String unit;
    @Min(value = 0, message = "Minimum value must be greater than or equal to 0")
    float minValue;
    @Min(value = 0, message = "Maximum value must be greater than or equal to 0")
    float maxValue;
    Long typeAnalyseId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime updatedAt;
}
