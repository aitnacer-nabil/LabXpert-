package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.PatientDto;
import com.aitnacer.LabXpert.service.impl.PatientServiveImp;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constant.BASE_API_URL +"patient")
@AllArgsConstructor

public class PatientController {
    final PatientServiveImp patientServiveImp;
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatient(){
        return ResponseEntity.ok(patientServiveImp.getAllPatient());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatiientById(@PathVariable(name = "id") Long id) {
       PatientDto patientDto = patientServiveImp.getPatientById(id);
        return ResponseEntity.ok(patientDto);
    }
    @PostMapping
    public ResponseEntity<PatientDto> createPatient( @RequestBody @Valid PatientDto patientDto) {
       PatientDto patientDto1 = patientServiveImp.createPatient(patientDto);
        return new ResponseEntity<>(patientDto1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable("id") Long id,  @RequestBody PatientDto patientDto)  {
        return ResponseEntity.ok(patientServiveImp.updatePatient(id, patientDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable("id") Long id)  {
        patientServiveImp.deletePatient(id);
        return ResponseEntity.ok("Patient with id: " + id + " has been deleted successfully!");
    }

    }
