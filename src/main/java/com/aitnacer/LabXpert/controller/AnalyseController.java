package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.AnalyseDto;
import com.aitnacer.LabXpert.dtos.TestDto;
import com.aitnacer.LabXpert.dtos.TypeAnalyseDto;
import com.aitnacer.LabXpert.service.IAnalyseService;
import com.aitnacer.LabXpert.service.ITestService;
import com.aitnacer.LabXpert.service.ITypeAnalyseService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constant.BASE_API_URL +"analyse")
@AllArgsConstructor
@Slf4j
public class AnalyseController {

    private IAnalyseService analyseService;
    private ITypeAnalyseService typeAnalyseService;
    private ITestService testService;

    @PostMapping
    public ResponseEntity<AnalyseDto> createAnalyse(@Valid @RequestBody AnalyseDto analyseDto) {
        AnalyseDto createdAnalyse = analyseService.createAnalyse(analyseDto);
        return new ResponseEntity<>(createdAnalyse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalyseDto> getAnalyseById(@PathVariable Long id) {
        AnalyseDto retrievedAnalyse = analyseService.getAnalyseById(id);
        return new ResponseEntity<>(retrievedAnalyse, HttpStatus.OK);
    }
    @GetMapping("/{id}/all")
    public ResponseEntity<AnalyseDto> getAnalyseAll(@PathVariable Long id) {
        AnalyseDto retrievedAnalyse = analyseService.getAnalyseById(id);
        List<TypeAnalyseDto> typeAnalyseDtos = typeAnalyseService.getAllTypeAnalysesForAnalysis(id);
        typeAnalyseDtos.forEach(typeAnalyseDto -> {
            List<TestDto>  allByTypeAnalyseAndAnalyse = testService.findALLByTypeAnalyseAndAnalyse(id,typeAnalyseDto.getId());
            if (typeAnalyseDto.getTests() == null){
                typeAnalyseDto.setTests(new ArrayList<>());
            }
            typeAnalyseDto.getTests().addAll(allByTypeAnalyseAndAnalyse);
        });
        retrievedAnalyse.setTypeAnalyses(typeAnalyseDtos);

        return new ResponseEntity<>(retrievedAnalyse, HttpStatus.OK);
    }
    @GetMapping("/{id}/type-analyses")
    public ResponseEntity<List<TypeAnalyseDto>> getAllTypeAnalysesForAnalysis(@PathVariable Long id) {
        List<TypeAnalyseDto> typeAnalyseDtos = typeAnalyseService.getAllTypeAnalysesForAnalysis(id);
        return new ResponseEntity<>(typeAnalyseDtos, HttpStatus.OK);
    }
    @GetMapping("/{analysisId}/type-analyses/{typeAnalyseId}/tests")
    public ResponseEntity<List<TestDto>> findALLByTypeAnalyseAndAnalyse(@PathVariable Long analysisId,@PathVariable Long typeAnalyseId) {
        List<TestDto> allByTypeAnalyseAndAnalyse = testService.findALLByTypeAnalyseAndAnalyse(analysisId,typeAnalyseId);

        return new ResponseEntity<>(allByTypeAnalyseAndAnalyse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AnalyseDto>> getAllAnalyses() {
        List<AnalyseDto> allAnalyses = analyseService.getAllAnalyses();
        return new ResponseEntity<>(allAnalyses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnalyseDto> updateAnalyse(@PathVariable Long id, @Valid @RequestBody AnalyseDto analyseDto) {
        AnalyseDto updatedAnalyse = analyseService.updateAnalyse(id, analyseDto);
        return new ResponseEntity<>(updatedAnalyse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id)  {
        Map<String, Object> response = new HashMap<>();
        analyseService.deleteAnalyse(id);
        response.put("success", true);
        response.put("message", "Analyse with id: " + id + " has been deleted successfully!");
        return ResponseEntity.ok(response);
    }
}

