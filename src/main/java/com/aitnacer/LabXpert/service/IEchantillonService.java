package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.echantillon.*;
import com.aitnacer.LabXpert.dtos.patient.PatientEchantillonDto;

import java.util.List;

public interface IEchantillonService {

    List<EchantillonResponseDto> getAllEchantillons();

    EchantillonDto getEchantillonsById(Long id);

    EchantillonDto createEchantillon(EchantillonRequestDto echantillonRequestDto);

    EchantillonDto updateEChantillon(Long id, EchantillonDto  echantillonDto);

    void deleteEchantillon(Long id);
    PatientEchantillonDto getEchantillonsByPatientId(long patientId);
    EchantillonDto getEchantillonsByPatientIdAndCode(long patientId , String echantillonCode);
    EchantillonUser getEchantillonByUserId(long userId);
    EchantillonDto getEchantillonByUserIdByCode(long userId , String echantillonCode);
}
