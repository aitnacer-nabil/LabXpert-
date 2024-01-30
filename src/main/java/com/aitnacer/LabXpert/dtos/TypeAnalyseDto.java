package com.aitnacer.LabXpert.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.TypeAnalyse}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeAnalyseDto implements Serializable {
    Long id;
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    String nom;
    @NotNull(message = "Analyse ID cannot be null")
    Long analyseId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime updatedAt;
    List<TestDto> tests;

}

