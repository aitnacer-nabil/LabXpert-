package com.aitnacer.LabXpert.dtos;

import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Analyse}
 */
@Value
public class AnalyseDto implements Serializable {
    Long id;
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    String nom;
    boolean deleted;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}