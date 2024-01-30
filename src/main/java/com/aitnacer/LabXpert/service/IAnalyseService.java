package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.analyse.AnalyseRequestDto;
import com.aitnacer.LabXpert.dtos.AnalyseDto;

import java.util.List;

public interface IAnalyseService {
    AnalyseDto createAnalyse(AnalyseDto analyseDto);
    void creatAnalyse(AnalyseRequestDto analyseRequestDto);

    AnalyseDto getAnalyseById(Long id);

    List<AnalyseDto> getAllAnalyses();

    AnalyseDto updateAnalyse(Long id, AnalyseDto analyseDto);

    void deleteAnalyse(Long id);
}
