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
import java.util.stream.Collectors;

import static com.aitnacer.LabXpert.utils.Utils.isStringValid;

@Service
@AllArgsConstructor
public class TestService implements ITestService {
    private final TestRepository testRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<TestDto> getAllTest() {
        List<Test> tests = testRepository.findByDeletedFalse();

        return tests.stream().map((element) -> modelMapper.map(element, TestDto.class)).collect(Collectors.toList());
    }

    @Override
    public TestDto getTestById(Long id) {
        Test test = testRepository.findByIdAndDeletedFalse(id).orElseThrow(new ApiException(String.format("No testValeur found for this id %s",id), HttpStatus.BAD_REQUEST));
        return modelMapper.map(test, TestDto.class);
    }

    @Override
    public TestDto createTest(TestDto testDto) {
        Test testValide = validateTestValeurDto(testDto);
        Test test = testRepository.save(testValide);

        return modelMapper.map(test, TestDto.class);
    }

    @Override
    public TestDto updateTest(Long id, TestDto testDto) {
        testRepository.findByIdAndDeletedFalse(id).orElseThrow(new ApiException(String.format("No testValeur found for this id %s",id), HttpStatus.BAD_REQUEST));
        Test testValidated = validateTestValeurDto(testDto);
        testValidated.setId(id);
        Test test = testRepository.save(testValidated);
        return modelMapper.map(test, TestDto.class);

    }
    private Test validateTestValeurDto(TestDto testDto){
        Test test = new Test();
        String newNom = testDto.getNom();
        if (isStringValid(newNom, 2)) {
            test.setNom(newNom);
        } else {
            throw new ApiException("Invalid 'nom' field. It must not be null, empty, and should have a minimum length of 2 characters.", HttpStatus.BAD_REQUEST);
        }

        // Validate the 'unit' field
        String newUnit = testDto.getUnit();
        if (isStringValid(newUnit, 0)) {
            test.setUnit(newUnit);
        } else {
            throw new ApiException("Invalid 'unit' field. It must not be null.", HttpStatus.BAD_REQUEST);
        }

        // Validate the 'minValue' field
        float newMinValue = testDto.getMinValue();
        if (newMinValue >= 0) {
            test.setMinValue(newMinValue);
        } else {
            throw new ApiException("Invalid 'minValue' field. It must be greater than or equal to 0.", HttpStatus.BAD_REQUEST);
        }

        // Validate the 'maxValue' field
        float newMaxValue = testDto.getMaxValue();
        if (newMaxValue >= 0) {
            test.setMaxValue(newMaxValue);
        } else {
            throw new ApiException("Invalid 'maxValue' field. It must be greater than or equal to 0.", HttpStatus.BAD_REQUEST);
        }
        return test;
    }
}
