package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.AnalyseDto;
import com.aitnacer.LabXpert.dtos.FournisseurDTO;
import com.aitnacer.LabXpert.entity.Analyse;
import com.aitnacer.LabXpert.entity.Fournisseur;
import com.aitnacer.LabXpert.repository.AnalyseRepository;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class AnalyseServiceImplTest {


    @ExtendWith(MockitoExtension.class)

        @Mock
        private AnalyseRepository analyseRepository;
        @InjectMocks
        private AnalyseServiceImpl analyseService;
        private ModelMapper modelMapper;

        @BeforeEach
        public void setup(){
            analyseRepository= Mockito.mock(AnalyseRepository.class);
            modelMapper=new ModelMapper();
            analyseService=new AnalyseServiceImpl(analyseRepository,modelMapper);

        }
        @Test
        void createAnalyse() {

            Analyse analyse=Analyse.builder()
                    .id(1L)
                    .nom("salma")
                    .createdAt(LocalDateTime.now())
                    .build();
            AnalyseDto analyseDto = AnalyseDto.builder()

                    .id(1L)
                    .nom("salma")
                    .createdAt(LocalDateTime.now())
                    .build();
            given(analyseRepository.save(Mockito.any(Analyse.class))).willReturn(analyse);


            // Call the method to test
            AnalyseDto reslt = analyseService.createAnalyse(analyseDto);
            assertThat(reslt).isNotNull();
            System.out.println(reslt);

        }

        @Test
        void getAnalyseById() {
            Analyse analyse=Analyse.builder()
                    .id(1L)
                    .nom("salma")
                    .createdAt(LocalDateTime.now())
                    .build();

            //given
            given(analyseRepository.findByIdAndDeletedFalse(1L)).willReturn(Optional.of(analyse));
            AnalyseDto analyseDto=analyseService.getAnalyseById(1L);
            Assertions.assertThat(analyseDto).isNotNull();
            assertThat(analyseDto.getId()).isEqualTo(1)
            ;
            System.out.println(analyseDto);

        }

        @Test
        void updateAnaluse() {
            AnalyseDto analyseDto=AnalyseDto.builder()
                    .id(1L)
                    .nom("salma")
                    .createdAt(LocalDateTime.now())
                    .build();
            Analyse analyse=Analyse.builder()
                    .id(1L)
                    .nom("salma")
                    .createdAt(LocalDateTime.now())
                    .build();

            given(analyseRepository.save(Mockito.any(Analyse.class))).willReturn(analyse);


            // Call the method to test
            AnalyseDto reslt = analyseService.createAnalyse(analyseDto);
            assertThat(reslt).isNotNull();
            System.out.println(reslt);
        }

        @Test
        void deleteAnalyuse() {
            Analyse analyse=Analyse.builder()
                    .id(1L)
                    .nom("salma")
                    .createdAt(LocalDateTime.now())
                    .build();
            given(analyseRepository.findByIdAndDeletedFalse(1l)).willReturn(Optional.of(analyse));
            given(analyseRepository.save(analyse)).willReturn(analyse);
            analyse.setDeleted(true);
            analyseService.deleteAnalyse(1l);

            assertThat(analyse.isDeleted()).isTrue();
        }

        @Test
        void getAllAnalyse() {
            Analyse analyse=Analyse.builder()
                    .id(1L)
                    .nom("salma")
                    .createdAt(LocalDateTime.now())
                    .build();
            Analyse analyse1=Analyse.builder()
                    .id(1L)
                    .nom("salma")
                    .createdAt(LocalDateTime.now())
                    .build();

            //given
            given(analyseRepository.findByDeletedFalse()).willReturn(Stream.of(analyse).collect(Collectors.toList()));
            List<AnalyseDto> analyseDtos=analyseService.getAllAnalyses();
            //then
            Assertions.assertThat(analyseDtos).isNotNull();
            Assertions.assertThat(analyseDtos.size()).isEqualTo(1);
        }


    }