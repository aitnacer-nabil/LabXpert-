package com.aitnacer.LabXpert.dtos.echantillon;

import com.aitnacer.LabXpert.dtos.ReactifAnalyseResponseDto;
import com.aitnacer.LabXpert.dtos.reactif.ReactifAnalyseDto;
import com.aitnacer.LabXpert.entity.ReactifAnalyse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime dateDeReception;

    @NotEmpty(message = "Echantillon code cannot be empty")
    @NotNull(message = "Echantillon code cannot be null")
    String echantillonCode;

    @NotNull(message = "Patient Id cannot be null")
    Long patientId;

    @NotNull(message = "Utilisateur Id cannot be null")
    Long utilisateurId;
    boolean assigned;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime updatedAt;

    List<ReactifAnalyse> reactifAnalyses;
}