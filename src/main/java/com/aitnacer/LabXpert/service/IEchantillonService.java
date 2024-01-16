package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.EchantillonDto;
import lombok.extern.java.Log;

import java.util.List;

public interface IEchantillonService {

    List<EchantillonDto> getAllEchantillons();

    EchantillonDto getEchantillonsById(Long id);

    EchantillonDto createEchantillon(EchantillonDto echantillonDto);

    EchantillonDto updateEChantillon(Long id, EchantillonDto echantillonDto);

    void deleteEchantillon(Log id);
}
