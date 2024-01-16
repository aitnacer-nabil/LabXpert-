package com.aitnacer.LabXpert.dtos;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Echantillon}
 */
@Value
public class EchantillonDto implements Serializable {
    Long id;
    LocalDateTime dateDeReception;
    String echantillonCode;
    Long patientId;
    Long UtilisateurId;

}