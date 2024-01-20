package com.aitnacer.LabXpert.dtos.echantillon;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Echantillon}
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EchantillonDto implements Serializable {
    @NotNull(message = "Id cannot be null")
    Long id;

    @NotNull(message = "Date of reception cannot be null")
    LocalDateTime dateDeReception;

    @NotEmpty(message = "Echantillon code cannot be empty")
    @NotNull(message = "Echantillon code cannot be null")
    String echantillonCode;

    @NotNull(message = "Patient Id cannot be null")
    Long patientId;

    @NotNull(message = "Utilisateur Id cannot be null")
    Long utilisateurId;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}