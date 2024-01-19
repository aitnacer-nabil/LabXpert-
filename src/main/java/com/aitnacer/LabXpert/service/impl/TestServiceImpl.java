package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.TestDto;
import com.aitnacer.LabXpert.entity.Result;
import com.aitnacer.LabXpert.entity.Test;
import com.aitnacer.LabXpert.entity.TestStandardValue;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.TestRepository;
import com.aitnacer.LabXpert.repository.TestStandardValueRepository;
import com.aitnacer.LabXpert.service.ITestService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestServiceImpl implements ITestService {
    final TestRepository testRepository;
    private final ModelMapper modelMapper;
    final TestStandardValueRepository testStandardValueRepository;
    final  ResultServiceImpl resultService;

    @Override
    public TestDto getTestById(Long testId) {
        Test test = testRepository.findByIdAndDeletedFalse(testId).orElseThrow(new ApiException("Np test found for this id", HttpStatus.BAD_REQUEST));
        return modelMapper.map(test, TestDto.class);
    }

    @Override
    public List<TestDto> getTestsByTypeAnalyse(Long typeAnalyseId) {
        //TODO getTestsByTypeAnalyse
        return null;
    }

    @Override
    public List<TestDto> getAllTests() {
        List<Test> tests = testRepository.findByDeletedFalse();
        System.out.println(tests);
        return tests.stream().map((element) -> modelMapper.map(element, TestDto.class)).collect(Collectors.toList());
    }

    @Override
    public TestDto saveTest(TestDto testDto) {
        System.out.println(testDto);
        TestStandardValue testStandardValue = testStandardValueRepository.findByIdAndDeletedFalse(testDto.getTestStandardValueId()).orElseThrow(new ApiException("No testStandardValue found for this id : " + testDto.getTestStandardValueId(), HttpStatus.BAD_REQUEST));
        if(testStandardValue.getTest() != null){
            throw  new ApiException("testStandardVaue already assing to test ",HttpStatus.BAD_REQUEST);

        }
        Result result = resultService.save(testDto.getResultResult());
        Test test = modelMapper.map(testDto, Test.class);
        test.setResult(result);
        test.setTestStandardValue(testStandardValue);
        Test testSaved = testRepository.save(test);
        testStandardValue.setTest(testSaved);

        return modelMapper.map(testSaved, TestDto.class);
    }

    @Override
    public TestDto updateTest(long id, TestDto testDto) {
        Test test = testRepository.findByIdAndDeletedFalse(id).orElseThrow(new ApiException(String.format("No test found for this id : %s",id),HttpStatus.BAD_REQUEST));
        if(testDto.getTestStandardValueId() != null && testDto.getTestStandardValueId() > 0){
            TestStandardValue testStandardValue = testStandardValueRepository.findByIdAndDeletedFalse(testDto.getTestStandardValueId()).orElseThrow(new ApiException("No testStandardValue found for this id : " + testDto.getTestStandardValueId(), HttpStatus.BAD_REQUEST));
           if(test.getTestStandardValue() == null){
               if(testStandardValue.getTest() != null){
                   throw  new ApiException("testStandardVaue already assing to test ",HttpStatus.BAD_REQUEST);

               }
               test.setTestStandardValue(testStandardValue);
               testStandardValue.setTest(test);
           } else if(!testStandardValue.getTest().equals(test)){
               test.setTestStandardValue(null);
               testStandardValue.setTest(test);
               test.setTestStandardValue(testStandardValue);
           }

        }
        if( testDto.getResultResult() > 0){
            if(test.getResult() != null){
                test.getResult().setResult(testDto.getResultResult());
            } else {
                Result result = resultService.save(testDto.getResultResult());
                test.setResult(result);
            }

        }
        if(testDto.getNom() != "" && testDto.getNom() != null){
            test.setNom(test.getNom());
        }
        if(testDto.getTypeAnalyseId() != null && testDto.getTypeAnalyseId() > 0){
            //test.setTypeAnalyse();//TODO typeanalyse
        }
        return modelMapper.map(testRepository.save(test), TestDto.class);
    }

    @Override
    public void deleteTest(Long testId) {

    }
}
