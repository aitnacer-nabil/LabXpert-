package com.aitnacer.LabXpert.controller;


import com.aitnacer.LabXpert.dtos.SimpleAnalyseResponseDto;
import com.aitnacer.LabXpert.dtos.result.ResultRequestDto;
import com.aitnacer.LabXpert.entity.Result;
import com.aitnacer.LabXpert.entity.SimpleAnalyse;
import com.aitnacer.LabXpert.entity.Test;
import com.aitnacer.LabXpert.service.IResultService;
import com.aitnacer.LabXpert.service.ISimpleAnalyseService;
import com.aitnacer.LabXpert.service.ITestService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(Constant.BASE_API_URL + "result")
@AllArgsConstructor
@Slf4j
public class ResultController {
    private ISimpleAnalyseService simpleAnalyseService;
    private IResultService resultService;
  private ITestService testService;
    private final ModelMapper modelMapper;

    @PostMapping("/sample-analyse/{sampleAnalyseId}")
    public ResponseEntity<SimpleAnalyseResponseDto> createAnalyse(@PathVariable(name = "sampleAnalyseId") long sampleAnalyseId, @Valid @RequestBody ResultRequestDto resultRequestDto) {
        log.info("requestBody {} ", resultRequestDto);
        SimpleAnalyse simpleAnalyse = simpleAnalyseService.getSimpleAnalyseById(sampleAnalyseId);
        List<Result> results = new ArrayList<>();
        resultRequestDto.getResults().forEach(resultDto -> {
            Test test = modelMapper.map(testService.getTestById(resultDto.getTestId()), Test.class);
            Result result = resultService.createResult(Result.builder().test(test).value(resultDto.getValue()).build());
            results.add(result);
        });
        simpleAnalyse.setResults(results);
        SimpleAnalyse updatedSimpleAnalyse =  simpleAnalyseService.updateSimpleAnalyse(simpleAnalyse);
        return ResponseEntity.ok(modelMapper.map(updatedSimpleAnalyse, SimpleAnalyseResponseDto.class));
    }
}
