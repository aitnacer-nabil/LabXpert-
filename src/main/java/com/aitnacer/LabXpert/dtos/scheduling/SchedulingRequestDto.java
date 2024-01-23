package com.aitnacer.LabXpert.dtos.scheduling;

import com.aitnacer.LabXpert.dtos.reactif.ReactifQteDto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.SimpleAnalyse}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchedulingRequestDto implements Serializable {
    Long id;
    @NotNull(message = "Start date cannot be null")
    LocalDateTime dateDebut;
    String Commentaire;
    @NotNull(message = "Utilisateur ID cannot be null")
    Long utilisateurId;
    @NotNull(message = "Echantillon ID cannot be null")
    Long echantillonId;
    @NotNull(message = "Analyse ID cannot be null")
    Long analyseId;
    @NotNull
    List<ReactifQteDto> reactifs;
}