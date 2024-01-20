package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.PatientDto;
import com.aitnacer.LabXpert.entity.Patient;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.PatientRepository;
import com.aitnacer.LabXpert.service.IPatientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@ComponentScan
public class PatientServiveImp implements IPatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> patients = patientRepository.findByDeletedFalse();
        return patients.stream().map(patient -> modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ApiException("patient not found with  ", id));

        return modelMapper.map(patient, PatientDto.class);
    }

    public PatientDto createPatient(PatientDto patientDto) {
        // TODO verification for patient
        Patient patient = modelMapper.map(patientDto, Patient.class);
        Patient patientSave = patientRepository.save(patient);
        System.out.println(patientSave);

        PatientDto patientDto1 = modelMapper.map(patientSave, PatientDto.class);
        System.out.println(patientDto1);
        return patientDto1;

    }

    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        //TODO trow exption not found and validation
        Patient existingPatient = patientRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ApiException("patient not found with  ", id));
        //TODO validation
        existingPatient.setPrenom(patientDto.getPrenom());
        existingPatient.setNom(patientDto.getNom());
        existingPatient.setAdresse(patientDto.getAdresse());
        existingPatient.setTelephone(patientDto.getTelephone());
        existingPatient.setSexe(patientDto.getSexe());
        Patient updatePatient = patientRepository.save(existingPatient);
        updatePatient.setId(id);
        return modelMapper.map(updatePatient, PatientDto.class);

    }

    @Override
    public void deletePatient(Long id) {
        //TODO add exption
        Patient patient = patientRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ApiException("patient not found with  ", id));
        patient.setDeleted(true);
        patientRepository.save(patient);

    }


}
