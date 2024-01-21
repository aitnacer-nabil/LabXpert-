package com.aitnacer.LabXpert.dtos.echantillon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EchantillonNoPatientIdDto {

    Long id;
    LocalDateTime dateDeReception;
    String echantillonCode;
    Long utilisateurId;
    boolean assigned;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
