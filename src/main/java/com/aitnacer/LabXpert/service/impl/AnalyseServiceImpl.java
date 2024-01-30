package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.analyse.AnalyseRequestDto;
import com.aitnacer.LabXpert.dtos.AnalyseDto;
import com.aitnacer.LabXpert.entity.Analyse;
import com.aitnacer.LabXpert.entity.Test;
import com.aitnacer.LabXpert.entity.TypeAnalyse;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.AnalyseRepository;
import com.aitnacer.LabXpert.repository.TestRepository;
import com.aitnacer.LabXpert.repository.TypeAnalyseRepository;
import com.aitnacer.LabXpert.service.IAnalyseService;
import com.aitnacer.LabXpert.utils.EntityExistenceChecker;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ComponentScan
@AllArgsConstructor
public class AnalyseServiceImpl implements IAnalyseService, EntityExistenceChecker<Analyse> {
    private final AnalyseRepository analyseRepository;
    private final ModelMapper modelMapper;
    private final TestRepository testRepository;
    private final TypeAnalyseRepository typeAnalyseRepository;

    @Override
    public AnalyseDto createAnalyse(AnalyseDto analyseDto) {
        Analyse analyse = modelMapper.map(analyseDto, Analyse.class);
        Analyse analyseSaved = analyseRepository.save(analyse);
        return modelMapper.map(analyseSaved, AnalyseDto.class);
    }

    @Override
    public void creatAnalyse(AnalyseRequestDto analyseRequestDto) {
        Analyse analyse = Analyse.builder().nom(analyseRequestDto.getNomAnalyse()).build();
        Analyse analyseSaved = analyseRepository.save(analyse);
        List<Test> tests = new ArrayList<>();
        List<TypeAnalyse> typeAnalyses = analyseRequestDto.getTypeAnalyseDRequestDtotos().stream().map(typeAnalyseDRequestDtoto -> {
            if (typeAnalyseDRequestDtoto.getNomTypeAnalyse() == null || typeAnalyseDRequestDtoto.getNomTypeAnalyse().isEmpty()) {
                throw new ValidationException("Name cannot be null or empty");
            }
            TypeAnalyse typeAnalyse = TypeAnalyse.builder().nom(typeAnalyseDRequestDtoto.getNomTypeAnalyse())
                    .analyse(analyseSaved)
                    .build();
            TypeAnalyse typeAnalyseSaved = typeAnalyseRepository.save(typeAnalyse);
            typeAnalyseDRequestDtoto.getTests().forEach(testRequestDto -> {
                Test test = Test.builder().typeAnalyse(typeAnalyseSaved)
                        .unit(testRequestDto.getUnit())
                        .maxValue(testRequestDto.getMaxValue())
                        .minValue(testRequestDto.getMinValue())
                        .nom(testRequestDto.getNom())
                        .build();
                Test testSaved = testRepository.save(test);
                tests.add(testSaved);
            });

            return typeAnalyseSaved ;

        }).collect(Collectors.toList());

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
