package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.PatientDto;

import java.util.List;

public interface IPatientService {
    List<PatientDto> getAllPatient();
    PatientDto getPatientById(Long id);
    PatientDto createPatient(PatientDto patientDto);
    PatientDto updatePatient(Long id ,PatientDto patientDto);

    void deletePatient (Long id);


}
