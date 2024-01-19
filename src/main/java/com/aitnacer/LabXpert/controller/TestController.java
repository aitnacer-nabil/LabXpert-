package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.TestDto;
import com.aitnacer.LabXpert.service.impl.TestServiceImpl;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constant.BASE_API_URL +"test")
@AllArgsConstructor
public class TestController {
    final TestServiceImpl testService;

    @GetMapping
    public ResponseEntity<List<TestDto>> getAllTests(){
        return ResponseEntity.ok(testService.getAllTests());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TestDto> getTestById(@PathVariable(name = "id") Long id) {
        TestDto testDto = testService.getTestById(id);
        return ResponseEntity.ok(testDto);
    }

    @PostMapping
    public ResponseEntity<TestDto> createTest(@RequestBody TestDto testDto) {
        TestDto testDto1 = testService.saveTest(testDto);
        return new ResponseEntity<>(testDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestDto> updateTest(@PathVariable("id") Long id, @Valid @RequestBody TestDto testDto)  {
        return ResponseEntity.ok(testService.updateTest(id, testDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id)  {
        testService.deleteTest(id);
        return ResponseEntity.ok("User with id: " + id + " has been deleted successfully!");
    }
}
