package com.aitnacer.LabXpert.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Echantillon}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EchantillonRequestDto {
    long id;
    @NotNull(message = "Date of reception cannot be null")
    LocalDateTime dateDeReception;

    @NotNull(message = "Patient Id cannot be null")
    Long patientId;

    @NotNull(message = "Utilisateur Id cannot be null")
    Long utilisateurId;
}
