package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.PatientDto;
import com.aitnacer.LabXpert.dtos.UtilisateurDto;

import java.util.List;

public interface IPatientService {
    List<PatientDto> getAllPatient();
    PatientDto getPatientById(Long id);
    PatientDto createPatient(PatientDto patientDto);
    PatientDto updatePatient(Long id ,PatientDto patientDto);



    void deleteUtilisateur(Long id);
}
