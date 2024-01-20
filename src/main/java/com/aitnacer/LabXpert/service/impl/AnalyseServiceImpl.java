package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.AnalyseDto;
import com.aitnacer.LabXpert.entity.Analyse;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.AnalyseRepository;
import com.aitnacer.LabXpert.service.IAnalyseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnalyseServiceImpl implements IAnalyseService {
    private final AnalyseRepository analyseRepository;
    private final ModelMapper modelMapper;

    @Override
    public AnalyseDto createAnalyse(AnalyseDto analyseDto) {
        Analyse analyse = modelMapper.map(analyseDto, Analyse.class);
        Analyse analyseSaved = analyseRepository.save(analyse);
        return modelMapper.map(analyseSaved, AnalyseDto.class);
    }

    @Override
    public AnalyseDto getAnalyseById(Long id) {
        Analyse analyse = ifExitsReturnAnalyseOrThrow(id);
        return modelMapper.map(analyse, AnalyseDto.class);
    }

    @Override
    public List<AnalyseDto> getAllAnalyses() {
        List<Analyse> analyses = analyseRepository.findByDeletedFalse();
        return analyses.stream().map((element) -> modelMapper.map(element, AnalyseDto.class)).collect(Collectors.toList());
    }

    @Override
    public AnalyseDto updateAnalyse(Long id, AnalyseDto analyseDto) {
        Analyse analyse = ifExitsReturnAnalyseOrThrow(id);
        analyse.setNom(analyse.getNom());
        analyse.setUpdatedAt(LocalDateTime.now());
        Analyse updatedAnalyse = analyseRepository.save(analyse);


        return modelMapper.map(updatedAnalyse, AnalyseDto.class);
    }

    @Override
    public void deleteAnalyse(Long id) {
        //TODO do something about delete
    }
    private Analyse ifExitsReturnAnalyseOrThrow(long id){
        return analyseRepository.findByIdAndDeletedFalse(id).orElseThrow(new ApiException("Analyse not found with",id));

    }
}
