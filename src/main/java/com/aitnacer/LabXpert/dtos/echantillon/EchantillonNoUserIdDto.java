package com.aitnacer.LabXpert.dtos.echantillon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EchantillonNoUserIdDto {
        Long id;
        LocalDateTime dateDeReception;
        String echantillonCode;
        Long patientId;
        LocalDateTime createdAt;
        LocalDateTime updatedAt;
}
