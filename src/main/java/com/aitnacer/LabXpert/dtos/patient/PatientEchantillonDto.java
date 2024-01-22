package com.aitnacer.LabXpert.dtos.patient;

import com.aitnacer.LabXpert.dtos.echantillon.EchantillonDto;
import com.aitnacer.LabXpert.dtos.echantillon.EchantillonNoPatientIdDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientEchantillonDto {

    private PatientIdDto patient;
    private List<EchantillonNoPatientIdDto> echantillons;
}
