package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.PatientDto;
import com.aitnacer.LabXpert.dtos.UtilisateurDto;
import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.Patient;
import com.aitnacer.LabXpert.entity.UserRole;
import com.aitnacer.LabXpert.entity.Utilisateur;
import com.aitnacer.LabXpert.repository.PatientRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PatientServiveImpTest {
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientServiveImp patientService;
    //private IPatientService PAtientSERVICE
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup(){
        patientRepository=Mockito.mock(PatientRepository.class);
        modelMapper=new ModelMapper();
        patientService=new PatientServiveImp(patientRepository,modelMapper);


    }


    @Test
    void getAllPatient() {
        Patient  patient=Patient.builder()
                .id(1L)
                .nom("salma")
                .prenom("SAI")
                .Adresse("quartie casa ")
                .telephone("9885456")
                .sexe(EnumSexe.valueOf("MALE"))
                .build();
        Patient  patient1=Patient.builder()
                .nom("KHADIJA")
                .prenom("KHALI")
                .Adresse("quartie FES ")
                .telephone("98856")
                .sexe(EnumSexe.valueOf("MALE"))
                .build();
        //given
        given(patientRepository.findByDeletedFalse()).willReturn(Stream.of(patient).collect(Collectors.toList()));
        List<PatientDto> patients=patientService.getAllPatient();
        //then
        Assertions.assertThat(patients).isNotNull();
        Assertions.assertThat(patients.size()).isEqualTo(1);
    }

    @Test
    void getPatientById() {
        Patient  patient=Patient.builder()
                .id(1L)
                .nom("salma")
                .prenom("SAI")
                .Adresse("quartie casa ")
                .telephone("9885456")
                .sexe(EnumSexe.valueOf("MALE"))
                .build();

        //given
        given(patientRepository.findByIdAndDeletedFalse(1L)).willReturn(Optional.of(patient));
        PatientDto patientDto=patientService.getPatientById(1L);
        Assertions.assertThat(patientDto).isNotNull();
        assertThat(patientDto.getId()).isEqualTo(1)
        ;
        System.out.println(patientDto);

    }

    @Test
    void createPatient() {
        Patient  patient=Patient.builder()
                .nom("salma")
                .prenom("SAI")
                .Adresse("quartie casa ")
                .telephone("9885456")
                .sexe(EnumSexe.valueOf("MALE"))
                .build();
        given(patientRepository.save(patient)).willReturn(patient);
        Patient savedPatient=patientRepository.save(patient);
        Assertions.assertThat(savedPatient).isNotNull();
        System.out.println(savedPatient);
    }


    @Test
    void updatePatient() {

        PatientDto patientDto = PatientDto.builder()
                .nom("lpl")
                .prenom("mpl")
                .Adresse("123 Main St")
                .telephone("123456789")
                .sexe(EnumSexe.MALE)

                .build();
        Patient patient = Patient.builder()
                .id(1l)
                .nom("kll")
                .prenom("lmm")
                .Adresse("lll")
                .telephone("23456789")
                .sexe(EnumSexe.MALE)
                .build();

        given(patientRepository.save(Mockito.any(Patient.class))).willReturn(patient);


        // Call the method to test
        PatientDto reslt = patientService.createPatient(patientDto);
        assertThat(reslt).isNotNull();
        System.out.println(reslt);
    }

    @Test
    void deletePatient() {
       Patient patient1=Patient.builder()
                .id(1l)
                .nom("John")
                .prenom("Doe")
                .Adresse("123 Main St")
                .telephone("123456789")
                .sexe(EnumSexe.MALE)


                .build();
        given(patientRepository.findByIdAndDeletedFalse(1l)).willReturn(Optional.of(patient1));
        given(patientRepository.save(patient1)).willReturn(patient1);
        patient1.setDeleted(true);
        patientService.deletePatient(1l);

        assertThat(patient1.isDeleted()).isTrue();

    }

}