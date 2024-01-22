package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.TestDto;

import java.util.List;

public interface ITestService {
    TestDto getTestById(Long testId);

    List<TestDto> getTestsByTypeAnalyse(Long typeAnalyseId);
    //TODO check if i need this method
   // List<TestDto> getTestsByResult(Long resultId);
    //TODO check if i need this method
//    List<TestDto> getTestsByStandardValue(Long standardValueId);

    List<TestDto> getAllTests();

    TestDto saveTest(TestDto testDto);
    TestDto updateTest(long id , TestDto testDto);

    void deleteTest(Long testId);


}
