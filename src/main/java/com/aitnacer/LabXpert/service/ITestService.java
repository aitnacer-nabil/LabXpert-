package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.TestDto;
import com.aitnacer.LabXpert.entity.Test;

import java.util.List;

public interface ITestService {

    List<TestDto> getAllTest();
    TestDto getTestById(Long id);
    TestDto createTest(TestDto testDto);
    TestDto updateTest(Long id , TestDto testDto);
    List<TestDto> findALLByTypeAnalyseAndAnalyse(long analysisId, long typeAnalyseId);

}
