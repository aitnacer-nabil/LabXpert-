package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.PatientDto;
import com.aitnacer.LabXpert.dtos.TestStandardValueDto;
import com.aitnacer.LabXpert.service.impl.TestStandardValueServiceImpl;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.BASE_API_URL +"testvalue")
@AllArgsConstructor
public class TestStandardValueController {
    private TestStandardValueServiceImpl testStandardValueService;
    @GetMapping
    public ResponseEntity<List<TestStandardValueDto>> getAllPatient(){
        return ResponseEntity.ok(testStandardValueService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TestStandardValueDto> getPatiientById(@PathVariable(name = "id") Long id) {
        TestStandardValueDto testStandardValueDto = testStandardValueService.findById(id);
        return ResponseEntity.ok(testStandardValueDto);
    }
    @PostMapping
    public ResponseEntity<TestStandardValueDto> createPatient( @RequestBody TestStandardValueDto testStandardValueDto) {
        TestStandardValueDto testStandardValueDto1 = testStandardValueService.save(testStandardValueDto);
        return new ResponseEntity<>(testStandardValueDto1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TestStandardValueDto> updatePatient(@PathVariable("id") Long id,  @RequestBody TestStandardValueDto testStandardValueDto)  {
        return ResponseEntity.ok(testStandardValueService.update(id, testStandardValueDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable("id") Long id)  {
        testStandardValueService.deleteById(id);
        return ResponseEntity.ok("TestStandardValue with id: " + id + " has been deleted successfully!");
    }
}
