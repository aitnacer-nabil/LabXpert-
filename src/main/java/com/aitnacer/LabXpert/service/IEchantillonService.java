package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.echantillon.EchantillonNoUserIdDto;
import com.aitnacer.LabXpert.dtos.echantillon.EchantillonRequestDto;
import com.aitnacer.LabXpert.dtos.echantillon.EchantillonDto;
import com.aitnacer.LabXpert.dtos.echantillon.EchantillonUser;
import com.aitnacer.LabXpert.dtos.patient.PatientEchantillonDto;

import java.util.List;

public interface IEchantillonService {

    List<EchantillonDto> getAllEchantillons();

    EchantillonDto getEchantillonsById(Long id);

    EchantillonDto createEchantillon(EchantillonRequestDto echantillonRequestDto);

    EchantillonDto updateEChantillon(Long id, EchantillonDto  echantillonDto);

    void deleteEchantillon(Long id);
    PatientEchantillonDto getEchantillonsByPatientId(long patientId);
    EchantillonDto getEchantillonsByPatientIdAndCode(long patientId , String echantillonCode);
    EchantillonUser getEchantillonByUserId(long userId);
    EchantillonDto getEchantillonByUserIdByCode(long userId , String echantillonCode);
}
