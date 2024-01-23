package com.aitnacer.LabXpert.dtos.echantillon;

import com.aitnacer.LabXpert.dtos.reactif.ReactifAnalyseDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime dateDeReception;

    @NotNull(message = "Patient Id cannot be null")
    Long patientId;

    @NotNull(message = "Utilisateur Id cannot be null")
    Long utilisateurId;

    List<ReactifAnalyseDto> reactifAnalyses;
}
