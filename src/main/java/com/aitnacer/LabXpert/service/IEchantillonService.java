package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.EchantillonRequestDto;
import com.aitnacer.LabXpert.dtos.EchantillonDto;

import java.util.List;

public interface IEchantillonService {

    List<EchantillonDto> getAllEchantillons();

    EchantillonDto getEchantillonsById(Long id);

    EchantillonDto createEchantillon(EchantillonRequestDto echantillonRequestDto);

    EchantillonDto updateEChantillon(Long id, EchantillonDto  echantillonDto);

    void deleteEchantillon(Long id);
}
