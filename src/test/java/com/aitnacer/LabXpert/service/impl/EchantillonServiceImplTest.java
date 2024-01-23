package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.echantillon.EchantillonDto;
import com.aitnacer.LabXpert.dtos.echantillon.EchantillonRequestDto;
import com.aitnacer.LabXpert.entity.*;
import com.aitnacer.LabXpert.repository.EchantillonRepository;
import com.aitnacer.LabXpert.repository.PatientRepository;
import com.aitnacer.LabXpert.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EchantillonServiceImplTest {
@Mock
   private EchantillonRepository echantillonRepository;
@Mock
 private EchantillonServiceImpl echantillonService;
    PatientRepository patientRepository;
    UserRepository userRepository;
 private ModelMapper modelMapper;
 @BeforeEach
 void setup(){
     echantillonRepository= Mockito.mock(EchantillonRepository.class);
     modelMapper=new ModelMapper();
     echantillonService=Mockito.mock(EchantillonServiceImpl.class);

 }
    @Test
    void getAllEchantillons() {
        Utilisateur utilisateur = Utilisateur.builder()
                .id(1L)
                .nom("nabil")
                .prenom("ait nacer")
                .sexe(EnumSexe.MALE)
                .role(UserRole.TECHNICIEN)
                .Adresse("hello")
                .userName("nabil")
                .telephone("0612341256")
                .password("12345")
                .build();

        Patient patient=Patient.builder()
                .id(1L)
                .nom("kawtar")
                .prenom("khawla")
                .Adresse("rue 7tanger")
                .telephone( "0987654321")
                .sexe(EnumSexe.FEMAL) // corrected the typo here
                .build();
        Echantillon echantillon1 = Echantillon.builder()
                .id(1L)
                .dateDeReception(LocalDateTime.now())
                .echantillonCode("ABC123")
                .patient(patient)
                .utilisateur(utilisateur)
                .build();
        given(echantillonRepository.findByDeletedFalse()).willReturn(Stream.of(echantillon1).collect(Collectors.toList()));
        List<EchantillonDto> echantillonDtoList=echantillonService.getAllEchantillons();
        //then
        Assertions.assertThat(echantillonDtoList).isNotNull();
        Assertions.assertThat(echantillonDtoList.size()).isEqualTo(1);


    }

    @Test
    void getEchantillonsById() {
        Utilisateur utilisateur = Utilisateur.builder()
                .id(1L)
                .nom("nabil")
                .prenom("ait nacer")
                .sexe(EnumSexe.MALE)
                .role(UserRole.TECHNICIEN)
                .Adresse("hello")
                .userName("nabil")
                .telephone("0612341256")
                .password("12345")
                .build();

        Patient patient=Patient.builder()
                .id(1L)
                .nom("kawtar")
                .prenom("khawla")
                .Adresse("rue 7tanger")
                .telephone( "0987654321")
                .sexe(EnumSexe.FEMAL) // corrected the typo here
                .build();
        Echantillon echantillon = Echantillon.builder()
                .id(1L)
                .dateDeReception(LocalDateTime.now())
                .echantillonCode("ABC123")
                .patient(patient)
                .utilisateur(utilisateur)
                .build();
        when(echantillonRepository.findByIdAndDeletedFalse(1L)).thenReturn(Optional.of(echantillon));

        EchantillonDto echantillonDto = echantillonService.getEchantillonsById(1L);
        assertThat(echantillonDto).isNotNull();
        assertThat(echantillonDto.getId()).isEqualTo(1);
        System.out.println(echantillonDto);

    }

    @Test
    void createEchantillon() {

        Utilisateur utilisateur = Utilisateur.builder()
                .id(1L)
                .nom("nabil")
                .prenom("ait nacer")
                .sexe(EnumSexe.MALE)
                .role(UserRole.TECHNICIEN)
                .Adresse("hello")
                .userName("nabil")
                .telephone("0612341256")
                .password("12345")
                .build();

        Patient patient=Patient.builder()
                .id(1L)
                .nom("kawtar")
                .prenom("khawla")
                .Adresse("rue 7tanger")
                .telephone( "0987654321")
                .sexe(EnumSexe.FEMAL) // corrected the typo here
                .build();


        Echantillon echantillon1 = Echantillon.builder()
                .id(1L)
                .dateDeReception(LocalDateTime.now())
                .echantillonCode("ABC123")
                .patient(patient)
                .utilisateur(utilisateur)
                .build();
        given(echantillonRepository.save(echantillon1)).willReturn(echantillon1);
        Echantillon savedEchantillon=echantillonRepository.save(echantillon1);
        Assertions.assertThat(savedEchantillon).isNotNull();
        System.out.println(savedEchantillon);



    }

    @Test
    void updateEChantillon() {
        Utilisateur utilisateur = Utilisateur.builder()
                .id(1L)
                .nom("kawtar")
                .prenom("mouslim")
                .sexe(EnumSexe.MALE)
                .role(UserRole.TECHNICIEN)
                .Adresse("hello")
                .userName("nabil")
                .telephone("0612341256")
                .password("12345")
                .build();

        Patient patient=Patient.builder()
                .id(1L)
                .nom("kawtar")
                .prenom("khawla")
                .Adresse("rue 7tanger")
                .telephone( "0987654321")
                .sexe(EnumSexe.FEMAL) // corrected the typo here
                .build();

        EchantillonRequestDto echantillonDto=EchantillonRequestDto.builder()
                .id(1L)
                .dateDeReception(LocalDateTime.now())
                .patientId(3L)
                .utilisateurId(3L)
                .build();
        Echantillon echantillon1 = Echantillon.builder()
                .id(1L)
                .dateDeReception(LocalDateTime.now())
                .echantillonCode("ABC123")
                .patient(patient)
                .utilisateur(utilisateur)
                        .build();

        given(echantillonRepository.save(Mockito.any(Echantillon.class))).willReturn(echantillon1);


        // Call the method to test
        EchantillonDto rest = echantillonService.createEchantillon(echantillonDto);
        assertThat(rest).isNotNull();
        System.out.println(rest);
    }

    @Test
    void deleteEchantillon() {
        Utilisateur utilisateur = Utilisateur.builder()
                .id(1L)
                .nom("kawtar")
                .prenom("mouslim")
                .sexe(EnumSexe.MALE)
                .role(UserRole.TECHNICIEN)
                .Adresse("hello")
                .userName("nabil")
                .telephone("0612341256")
                .password("12345")
                .build();

        Patient patient=Patient.builder()
                .id(1L)
                .nom("kawtar")
                .prenom("khawla")
                .Adresse("rue 7tanger")
                .telephone( "0987654321")
                .sexe(EnumSexe.FEMAL) // corrected the typo here
                .build();


        Echantillon echantillon1 = Echantillon.builder()
                .id(1L)
                .dateDeReception(LocalDateTime.now())
                .echantillonCode("ABC123")
                .patient(patient)
                .utilisateur(utilisateur)
                .build();

        given(echantillonRepository.findByIdAndDeletedFalse(1L)).willReturn(Optional.of(echantillon1));
        given(echantillonRepository.save(echantillon1)).willReturn(echantillon1);
        echantillon1.setDeleted(true);
        echantillonService.deleteEchantillon(1L);
        assertThat(echantillon1.isDeleted()).isTrue();
    }


}