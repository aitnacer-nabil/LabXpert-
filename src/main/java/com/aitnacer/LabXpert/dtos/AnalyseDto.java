package com.aitnacer.LabXpert.dtos;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Analyse}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalyseDto implements Serializable {
    Long id;
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    @Column(name = "nom")
    String nom;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}