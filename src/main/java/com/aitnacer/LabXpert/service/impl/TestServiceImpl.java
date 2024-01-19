package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.TestDto;
import com.aitnacer.LabXpert.entity.Test;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.TestRepository;
import com.aitnacer.LabXpert.service.ITestService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestServiceImpl implements ITestService {
    final TestRepository testRepository;
    private final ModelMapper modelMapper;

    @Override
    public TestDto getTestById(Long testId) {
        Test test = testRepository.findByIdAndDeletedFalse(testId).orElseThrow(new ApiException("Np test found for this id", HttpStatus.BAD_REQUEST));
        return modelMapper.map(test, TestDto.class);
    }

    @Override
    public List<TestDto> getTestsByTypeAnalyse(Long typeAnalyseId) {
        return null;
    }

    @Override
    public List<TestDto> getAllTests() {
        return null;
    }

    @Override
    public TestDto saveTest(TestDto testDto) {
        return null;
    }

    @Override
    public TestDto updateTest(long id, TestDto testDto) {
        return null;
    }

    @Override
    public void deleteTest(Long testId) {

    }
}
