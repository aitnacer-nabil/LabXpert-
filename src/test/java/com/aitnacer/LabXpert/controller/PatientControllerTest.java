package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.patient.PatientDto;
import com.aitnacer.LabXpert.entity.EnumSexe;

import com.aitnacer.LabXpert.service.IEchantillonService;
import com.aitnacer.LabXpert.service.IPatientService;
import com.aitnacer.LabXpert.service.impl.PatientServiveImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientController.class)

class PatientControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PatientServiveImp patientService;
    @MockBean
    private IEchantillonService iEchantillonService;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void getAllPatient() throws Exception {
        PatientDto patientDto=PatientDto.builder()
                .id(1L)
                .nom("salma")
                .prenom("khawla")
                .Adresse("quartie")
                .telephone("0987654321")
                .sexe(EnumSexe.MALE)
                .build();
        PatientDto patientDto1=PatientDto.builder()
                .nom("salma")
                .prenom("khawla")
                .Adresse("quartie FES ")
                .telephone("0987654321")
                .sexe(EnumSexe.MALE)
                .build();
        List<PatientDto>patientDtoList= Arrays.asList(patientDto, patientDto1);

        when(patientService.getAllPatient()).thenReturn(patientDtoList);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/patient")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nom").value("salma"))
                .andExpect(jsonPath("$[0].prenom").value("khawla"))
                .andExpect(jsonPath("$[0].adresse").value("quartie"))
                .andExpect(jsonPath("$[0].telephone").value("0987654321"))
                .andExpect(jsonPath("$[0].sexe").value("MALE"))
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        Assertions.assertNotNull(response);




    }

    @Test
    void getPatiientById() throws Exception {

        PatientDto patientDto=PatientDto.builder()
                .nom("mpqlùp")
                .prenom("khawla")
                .Adresse("quartie")
                .telephone("0987654321")
                .sexe(EnumSexe.MALE)
                .build();
        Long patientId = 1L;
        when(patientService.getPatientById(patientId)).thenReturn(patientDto);

        ResultActions response = mockMvc.perform(get("/api/v1/patient/{id}", patientId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", CoreMatchers.is(patientDto.getNom())))
                .andExpect(jsonPath("$.prenom", CoreMatchers.is(patientDto.getPrenom())))
                .andExpect(jsonPath("$.adresse", CoreMatchers.is(patientDto.getAdresse())))
                .andExpect(jsonPath("$.telephone", CoreMatchers.is(patientDto.getTelephone())))
                .andExpect(jsonPath("$.sexe", CoreMatchers.is(patientDto.getSexe().toString())));

    }

    @Test
    void createPatient() throws Exception {
        //given

        PatientDto patientDto=PatientDto.builder()
                //.id(1L)
                .nom("salma")
                .prenom("khawla")
                .Adresse("quartie")
                .telephone("0987654321")
                .sexe(EnumSexe.MALE)
                .build();

        given(patientService.createPatient(ArgumentMatchers.any()))
                .willAnswer((invocation)-> invocation.getArgument(0));

        //when
        ResultActions responce= mockMvc.perform(post("/api/v1/patient").
                contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patientDto))
        );

        //then verify
        responce.andExpect(status().isCreated())
                //.andExpect(jsonPath("$.id", CoreMatchers.is(patientDto.getId())))
                .andExpect(jsonPath("$.nom", CoreMatchers.is(patientDto.getNom())))
                .andExpect(jsonPath("$.prenom",CoreMatchers.is(patientDto.getPrenom())))
                .andExpect(jsonPath("$.adresse",CoreMatchers.is(patientDto.getAdresse())))
                .andExpect(jsonPath("$.telephone",CoreMatchers.is(patientDto.getTelephone())))
                .andExpect(jsonPath("$.sexe",CoreMatchers.is(patientDto.getSexe().name())));
    }

    @Test
    void updatePatient() throws Exception {
        PatientDto patientDto3 = PatientDto.builder()
                .nom("salma")
                .prenom("khawla")
                .Adresse("quartie")
                .telephone("0987654321")
                .sexe(EnumSexe.MALE)
                .build();
        Long patientid = 1L;
        when(patientService.updatePatient(patientid,patientDto3)).thenReturn(patientDto3);

        ResultActions response = mockMvc.perform(put("/api/v1/patient/{id}", patientid)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patientDto3)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", CoreMatchers.is(patientDto3.getNom())))
                .andExpect(jsonPath("$.prenom", CoreMatchers.is(patientDto3.getPrenom())))
                .andExpect(jsonPath("$.adresse", CoreMatchers.is(patientDto3.getAdresse())))
                .andExpect(jsonPath("$.telephone", CoreMatchers.is(patientDto3.getTelephone())))
                .andExpect(jsonPath("$.sexe", CoreMatchers.is(patientDto3.getSexe().name())));





    }

    // @SneakyThrows
    @Test
    void deletePatientById() throws Exception {

        Long patientId = 1L;
        doNothing().when(patientService).deletePatient(patientId);

        ResultActions response = mockMvc.perform(delete("/api/v1/patient/{id}", patientId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }
}