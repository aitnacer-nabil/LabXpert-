package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.AnalyseDto;
import com.aitnacer.LabXpert.entity.Analyse;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.AnalyseRepository;
import com.aitnacer.LabXpert.service.IAnalyseService;
import com.aitnacer.LabXpert.utils.EntityExistenceChecker;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan
@AllArgsConstructor
public class AnalyseServiceImpl implements IAnalyseService, EntityExistenceChecker<Analyse> {
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
        Analyse analyse = checkExistenceByIdOrThrow(id);
        return modelMapper.map(analyse, AnalyseDto.class);
    }

    @Override
    public List<AnalyseDto> getAllAnalyses() {
        List<Analyse> analyses = analyseRepository.findByDeletedFalse();
        return analyses.stream().map((element) -> modelMapper.map(element, AnalyseDto.class)).collect(Collectors.toList());
    }

    @Override
    public AnalyseDto updateAnalyse(Long id, AnalyseDto analyseDto) {
        Analyse analyse = checkExistenceByIdOrThrow(id);
        analyse.setNom(analyse.getNom());
        analyse.setUpdatedAt(LocalDateTime.now());
        Analyse updatedAnalyse = analyseRepository.save(analyse);


        return modelMapper.map(updatedAnalyse, AnalyseDto.class);
    }

    @Override
    public void deleteAnalyse(Long id) {
        //TODO do something about delete
    }


    @Override
    public Analyse checkExistenceByIdOrThrow(long id) {
        return analyseRepository.findByIdAndDeletedFalse(id).orElseThrow(new ApiException("Analyse not found with",id));
    }
}
