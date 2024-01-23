package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.FournisseurDTO;
import com.aitnacer.LabXpert.entity.Fournisseur;
import com.aitnacer.LabXpert.repository.FournisseurRepository;
import org.assertj.core.api.Assertions;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FournisseurServiceImplTest {
    @Mock
    private FournisseurRepository fournisseurRepository;
    @InjectMocks
    private FournisseurServiceImpl fournisseurService;
    //private IPatientService PAtientSERVICE
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup(){
        fournisseurRepository= Mockito.mock(FournisseurRepository.class);
        modelMapper=new ModelMapper();
        fournisseurService=new FournisseurServiceImpl(fournisseurRepository,modelMapper);

    }
    @Test
    void createFournisseur() {

        Fournisseur fournisseur=Fournisseur.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")
                .build();
        FournisseurDTO fournisseurDTO = FournisseurDTO.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")

                .build();
        given(fournisseurRepository.save(Mockito.any(Fournisseur.class))).willReturn(fournisseur);


        // Call the method to test
        FournisseurDTO reslt = fournisseurService.createFournisseur(fournisseurDTO);
        assertThat(reslt).isNotNull();
        System.out.println(reslt);

    }

    @Test
    void getFournisseurById() {

        Fournisseur fournisseur=Fournisseur.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")
                .build();
        //given
        given(fournisseurRepository.findByIdFournisseurAndDeletedFalse(1L)).willReturn(Optional.of(fournisseur));
        FournisseurDTO fournisseurDTO=fournisseurService.getFournisseurById(1L);
        Assertions.assertThat(fournisseurDTO).isNotNull();
        assertThat(fournisseurDTO.getIdFournisseur()).isEqualTo(1)
        ;
        System.out.println(fournisseurDTO);

    }

    @Test
    void updateFournisseur() {
        FournisseurDTO fournisseurDTO = FournisseurDTO.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")

                .build();
        Fournisseur fournisseur=Fournisseur.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")
                .build();

        given(fournisseurRepository.save(Mockito.any(Fournisseur.class))).willReturn(fournisseur);


        // Call the method to test
        FournisseurDTO reslt = fournisseurService.createFournisseur(fournisseurDTO);
        assertThat(reslt).isNotNull();
        System.out.println(reslt);
    }

    @Test
    void deleteFournisseur() {
        Fournisseur fournisseur=Fournisseur.builder()
            .idFournisseur(1L)
            .nom("salma")
            .adresse("casa")
            .tel("1234567")
            .build();
        given(fournisseurRepository.findByIdFournisseurAndDeletedFalse(1l)).willReturn(Optional.of(fournisseur));
        given(fournisseurRepository.save(fournisseur)).willReturn(fournisseur);
        fournisseur.setDeleted(true);
        fournisseurService.deleteFournisseur(1l);

        assertThat(fournisseur.isDeleted()).isTrue();
    }

    @Test
    void getAllFournisseur() {
        Fournisseur fournisseur=Fournisseur.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")
                .build();
        Fournisseur fournisseur1=Fournisseur.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")
                .build();

        //given
        given(fournisseurRepository.findByDeletedFalse()).willReturn(Stream.of(fournisseur).collect(Collectors.toList()));
        List<FournisseurDTO> fournisseurDTOList=fournisseurService.getAllFournisseur();
        //then
        Assertions.assertThat(fournisseurDTOList).isNotNull();
        Assertions.assertThat(fournisseurDTOList.size()).isEqualTo(1);
    }
}