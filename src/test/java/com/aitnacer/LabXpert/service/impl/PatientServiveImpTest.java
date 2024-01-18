package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.PatientDto;
import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.Patient;
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
        Assertions.assertThat(patients).isEmpty();
        Assertions.assertThat(patients.size()).isEqualTo(1);
    }

    @Test
    void getPatientById() {
        Patient  patient=Patient.builder()
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
        AssertionsForClassTypes.assertThat(patientDto.getId()).isEqualTo(1)
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

        // Préparer les données de test
        Long patientId = 1L;
        PatientDto patientDto1 = new PatientDto();
        patientDto1.setNom("LPLP");
        patientDto1.setPrenom("KOL");
        patientDto1.setAdresse("marakech");
        patientDto1.setTelephone("5677");
        patientDto1.setSexe(EnumSexe.MALE);
        // Autres attributs à mettre à jour...

        Patient existingPatient = new Patient();
        existingPatient.setId(patientId);
        // Définir d'autres attributs du patient existant...

        // Définir le comportement du repository mocké
        when(patientRepository.findById(eq(patientId))).thenReturn(Optional.of(existingPatient));
        when(patientRepository.save(any(Patient.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Appeler la méthode du service
     PatientDto updatedPatient1 = patientService.updatePatient(patientId, patientDto1);

        // Vérifier les appels de méthodes sur le repository mocké
        verify(patientRepository, times(1)).findById(eq(patientId));
        verify(patientRepository, times(1)).save(any(Patient.class));

        // Vérifier les assertions sur le patient mis à jour
        assertNotNull(updatedPatient1);
        assertEquals(patientDto1.getNom(), updatedPatient1.getNom());
        assertEquals(patientDto1.getPrenom(), updatedPatient1.getPrenom());
        assertEquals(patientDto1.getAdresse(), updatedPatient1.getAdresse());
        assertEquals(patientDto1.getTelephone(), updatedPatient1.getTelephone());
        assertEquals(patientDto1.getSexe(), updatedPatient1.getSexe());
        // Vérifier d'autres attributs mis à jour...
    }

    @Test
    void deletePatient() {
        //giv
        long patientId=1L;
        willDoNothing().given(patientRepository).deleteById(patientId);
        //when
        patientService.deletePatient(patientId);
        verify(patientRepository,times(1)).deleteById(patientId);
    }

}