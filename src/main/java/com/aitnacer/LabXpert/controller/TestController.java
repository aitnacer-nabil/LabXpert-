package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.TestDto;
import com.aitnacer.LabXpert.service.ITestService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(Constant.BASE_API_URL +"test")
@AllArgsConstructor
@Slf4j
public class TestController {
    private final ITestService testService;
    @PostMapping
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<TestDto> createTest(@Valid @RequestBody TestDto testDto) {
        TestDto createdTest = testService.createTest(testDto);
        return new ResponseEntity<>(createdTest, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('RESPONSABLE','TECHNICIEN')")
    public ResponseEntity<TestDto> getTest(@PathVariable Long id) {
        TestDto retrievedTest = testService.getTestById(id);
        return new ResponseEntity<>(retrievedTest, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('RESPONSABLE','TECHNICIEN')")
    public ResponseEntity<List<TestDto>> getAllTests() {
        List<TestDto> allTests = testService.getAllTest();
        return new ResponseEntity<>(allTests, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<TestDto> updateTest(@PathVariable Long id, @Valid @RequestBody TestDto testDto) {
        TestDto updatedTest = testService.updateTest(id, testDto);
        return new ResponseEntity<>(updatedTest, HttpStatus.OK);
    }

  //TODO if i want to delte test

}
