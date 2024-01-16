package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.PatientDto;
import com.aitnacer.LabXpert.dtos.UtilisateurDto;
import com.aitnacer.LabXpert.entity.Patient;
import com.aitnacer.LabXpert.entity.Utilisateur;
import com.aitnacer.LabXpert.repository.PatientRepository;
import com.aitnacer.LabXpert.service.IPatientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
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
        Patient patient = patientRepository.findByIdAndDeletedFalse(id).orElse(null);

        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        // TODO verification for patient
        Patient patient = modelMapper.map(patientDto, Patient.class);
        Patient patientSave = patientRepository.save(patient);
        return modelMapper.map(patientSave, PatientDto.class);
    }

    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        //TODO trow exption not found and validation
        Patient existingPatient = patientRepository.findByIdAndDeletedFalse(id).orElse(null);
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
        Patient patient = patientRepository.findByIdAndDeletedFalse(id).orElse(null);
        patient.setDeleted(true);
        patientRepository.save(patient);

    }


}
