package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.EchantillonDto;
import com.aitnacer.LabXpert.entity.Echantillon;
import com.aitnacer.LabXpert.repository.EchantillonRepository;
import com.aitnacer.LabXpert.service.IEchantillonService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EchantillonServiceImpl implements IEchantillonService {
    private final EchantillonRepository echantillonRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<EchantillonDto> getAllEchantillons() {
        List<Echantillon> echantillons = echantillonRepository.findByDeletedFalse();

        return echantillons.stream().map((element) -> modelMapper.map(element, EchantillonDto.class)).collect(Collectors.toList());
    }

    @Override
    public EchantillonDto getEchantillonsById(Long id) {
        //TODO HAndel Null exption
        Echantillon echantillon = echantillonRepository.findByIdAndDeletedFalse(id).orElse(null);
        return modelMapper.map(echantillon, EchantillonDto.class);
    }

    @Override
    public EchantillonDto createEchantillon(EchantillonDto echantillonDto) {
        Echantillon echantillon = modelMapper.map(echantillonDto, Echantillon.class);
        Echantillon savedEchantillon = echantillonRepository.save(echantillon);

        return modelMapper.map(echantillon, EchantillonDto.class);
    }

    @Override
    public EchantillonDto updateEChantillon(Long id, EchantillonDto echantillonDto) {
        //TODO trwo exption not found
        Echantillon echantillon = echantillonRepository.findByIdAndDeletedFalse(id).orElse(null);
        //TODO validate DAta

        return null;
    }

    @Override
    public void deleteEchantillon(Log id) {

    }
}
