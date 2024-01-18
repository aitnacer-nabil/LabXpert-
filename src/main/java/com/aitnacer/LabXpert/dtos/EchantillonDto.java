package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.entity.Echantillon;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link Echantillon}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EchantillonDto implements Serializable {
    @NotEmpty(message = "should have a date ") @NotNull(message = "should have a date ")
    @JsonView(EchantillonView.Response.class)
    LocalDateTime dateDeReception;
    @NotEmpty(message = "should have a echantillonCode ") @NotNull(message = "should have a echantillonCode ")
    @JsonView(EchantillonView.Response.class)
    String echantillonCode;
    @NotNull(message = "should have a patient Id  ")
    @JsonView(EchantillonView.Response.class)
    Long patientId;
    @JsonView(EchantillonView.FullResponse.class)
    PatientDto patient;
    @JsonView(EchantillonView.Response.class)
    Long utilisateurId;
    @JsonView(EchantillonView.FullResponse.class)
    UtilisateurDto utilisateurDto;
    @JsonView(EchantillonView.FullResponse.class)
    List<AnalyseDto> analyses;
    @JsonView(EchantillonView.FullResponse.class)
    List<Long> analysesId;
    @JsonView(EchantillonView.Response.class)
    boolean deleted;
}