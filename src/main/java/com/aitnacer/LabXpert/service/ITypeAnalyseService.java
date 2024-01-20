package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.TypeAnalyseDto;

import java.util.List;
import java.util.Optional;

public interface ITypeAnalyseService {
    List<TypeAnalyseDto> getAllTypeAnalyses();

    TypeAnalyseDto getTypeAnalyseById(Long id);

    TypeAnalyseDto createTypeAnalyse(TypeAnalyseDto typeAnalyseDto);

    TypeAnalyseDto updateTypeAnalyse(Long id, TypeAnalyseDto typeAnalyseDto);
     List<TypeAnalyseDto> getAllTypeAnalysesForAnalysis(long analysisId);
    void deleteTypeAnalyse(Long id);
}
