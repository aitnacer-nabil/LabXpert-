package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.TestDto;
import com.aitnacer.LabXpert.entity.Test;
import com.aitnacer.LabXpert.entity.TypeAnalyse;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.TestRepository;
import com.aitnacer.LabXpert.repository.TypeAnalyseRepository;
import com.aitnacer.LabXpert.service.ITestService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.aitnacer.LabXpert.utils.Utils.isStringValid;

@Service
@AllArgsConstructor
public class TestService implements ITestService {
    private final TestRepository testRepository;
    private final TypeAnalyseRepository typeAnalyseRepository;
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
        Test test = testRepository.save(modelMapper.map(testDto, Test.class));
        return modelMapper.map(test, TestDto.class);
    }

    @Override
    public TestDto updateTest(Long id, TestDto testDto) {
        Test test = testRepository.findByIdAndDeletedFalse(id).orElseThrow(new ApiException(String.format("No testValeur found for this id %s",id), HttpStatus.BAD_REQUEST));

        if (test.getTypeAnalyse().getId() != testDto.getTypeAnalyseId()){
            System.out.println(test.getTypeAnalyse().getId());
            System.out.println(testDto.getTypeAnalyseId());
            TypeAnalyse typeAnalyse = typeAnalyseRepository.findByIdAndDeletedFalse(testDto.getTypeAnalyseId()).orElseThrow(new ApiException("No testValeur found for this id %s",id));
                test.setTypeAnalyse(null);
                test.setTypeAnalyse(typeAnalyse);
        }


        test.setUpdatedAt(LocalDateTime.now());
        test.setNom(testDto.getNom());
        test.setUnit(testDto.getUnit());
        test.setMinValue(testDto.getMinValue());
        test.setMaxValue(testDto.getMaxValue());

        Test updatedTest = testRepository.save(test);

        return modelMapper.map(updatedTest, TestDto.class);

    }

}
