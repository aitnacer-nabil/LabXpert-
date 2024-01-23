package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.echantillon.EchantillonDto;
import com.aitnacer.LabXpert.dtos.patient.PatientDto;
import com.aitnacer.LabXpert.dtos.patient.PatientEchantillonDto;
import com.aitnacer.LabXpert.service.IEchantillonService;
import com.aitnacer.LabXpert.service.impl.PatientServiveImp;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constant.BASE_API_URL +"patient")
@AllArgsConstructor

public class PatientController {
    final PatientServiveImp patientServiveImp;
    final IEchantillonService iEchantillonService;

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatient(){
        return ResponseEntity.ok(patientServiveImp.getAllPatient());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatiientById(@PathVariable(name = "id") Long id) {
       PatientDto patientDto = patientServiveImp.getPatientById(id);
        return ResponseEntity.ok(patientDto);
    }
    @GetMapping("/{id}/echantillons")
    public ResponseEntity<PatientEchantillonDto> getEchantillonsByPatientId(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(iEchantillonService.getEchantillonsByPatientId(id));
    }
    @GetMapping("/{id}/echantillons/{echantillonCode}")
    public ResponseEntity<EchantillonDto> getEchantillonByPatientIdAndCode(@PathVariable(name = "id") Long id, @PathVariable(name = "echantillonCode") String echantillonCode) {

        return ResponseEntity.ok(iEchantillonService.getEchantillonsByPatientIdAndCode(id,echantillonCode));
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
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id)  {
        Map<String, Object> response = new HashMap<>();
        patientServiveImp.deletePatient(id);
        response.put("success", true);
        response.put("message", "Analyse with id: " + id + " has been deleted successfully!");
        return ResponseEntity.ok(response);
    }
    }
