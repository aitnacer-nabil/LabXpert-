package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.TestStandardValueDto;
import com.aitnacer.LabXpert.entity.Test;
import com.aitnacer.LabXpert.entity.TestStandardValue;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.TestRepository;
import com.aitnacer.LabXpert.repository.TestStandardValueRepository;
import com.aitnacer.LabXpert.service.ITestStandardValuer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestStandardValueServiceImpl implements ITestStandardValuer {
    private TestStandardValueRepository testStandardValueRepository;
    private TestRepository testRepository;
    private ModelMapper modelMapper;

    @Override
    public TestStandardValueDto findById(Long id) {
        TestStandardValue standardValue = testStandardValueRepository.findByIdAndDeletedFalse(id).orElseThrow(new ApiException("no TestStandardValue fond for this id :" + id, HttpStatus.BAD_REQUEST));
        return modelMapper.map(standardValue, TestStandardValueDto.class);
    }

    @Override
    public List<TestStandardValueDto> findAll() {
        List<TestStandardValue> testStandardValues = testStandardValueRepository.findByDeletedFalse();

        return testStandardValues.stream().map((element) -> modelMapper.map(element, TestStandardValueDto.class)).collect(Collectors.toList());
    }

    @Override
    public TestStandardValueDto save(TestStandardValueDto testStandardValueDto) {
        System.out.println(testStandardValueDto);
        if (testStandardValueDto.getMinValue() < 0) {
            throw new ValidationException("min value should not be below 0");
        }
        if (testStandardValueDto.getMaxValue() < 0) {
            throw new ValidationException("max value should not be below 0");
        }
        TestStandardValue testStandardValue = modelMapper.map(testStandardValueDto, TestStandardValue.class);
        TestStandardValue testStandardValueSaved = testStandardValueRepository.save(testStandardValue);

        return modelMapper.map(testStandardValueSaved, TestStandardValueDto.class);
    }

    @Override
    public TestStandardValueDto update(long id ,TestStandardValueDto testStandardValueDto) {
        Test test;
        if (testStandardValueDto.getMinValue() < 0) {
            throw new ValidationException("min value should not be below 0");
        }
        if (testStandardValueDto.getMaxValue() < 0) {
            throw new ValidationException("max value should not be below 0");
        }

      //  test = testRepository.findByIdAndDeletedFalse(testStandardValueDto.getTestId()).orElseThrow(new ApiException("Not test found for this id : ", HttpStatus.BAD_REQUEST));
        TestStandardValue testStandardValue = testStandardValueRepository.findByIdAndDeletedFalse(id).orElseThrow(new ApiException("no TestStandardValue fond for this id : "+id,HttpStatus.BAD_REQUEST));
       // testStandardValue.setTest(test);
        testStandardValue.setMaxValue(testStandardValueDto.getMaxValue());
        testStandardValue.setMinValue(testStandardValueDto.getMinValue());
        TestStandardValue testStandardValueSaved = testStandardValueRepository.save(testStandardValue);
      //  test.setTestStandardValue(testStandardValueSaved);
        return modelMapper.map(testStandardValueSaved, TestStandardValueDto.class);
    }

    @Override
    public void deleteById(Long id) {
        TestStandardValue testStandardValue = testStandardValueRepository.findByIdAndDeletedFalse(id).orElseThrow(new ApiException("no TestStandardValue fond for this id : "+id,HttpStatus.BAD_REQUEST));
        testStandardValue.setDeleted(true);
        testStandardValueRepository.save(testStandardValue);

    }
}
