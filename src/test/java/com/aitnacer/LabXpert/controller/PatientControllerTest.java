package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.PatientDto;
import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.Patient;
import com.aitnacer.LabXpert.service.IPatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.awt.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest

class PatientControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IPatientService patientService;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void getAllPatient() {
    }

    @Test
    void getPatiientById() {
    }

    @Test
    void createPatient() throws Exception {
        //given

        PatientDto patientDto=PatientDto.builder()

                .nom("salma")
                .prenom("khawla")
                .Adresse("quartie casa ")
                .telephone("0987654321")
                .sexe(EnumSexe.valueOf("MALE"))
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
                .andExpect(jsonPath("$.name", CoreMatchers.is(patientDto.getNom())))
                .andExpect(jsonPath("$.prenom",CoreMatchers.is(patientDto.getPrenom())))
                .andExpect(jsonPath("$.Adresse",CoreMatchers.is(patientDto.getAdresse())))
                .andExpect(jsonPath("$.telephone",CoreMatchers.is(patientDto.getTelephone())))
                .andExpect(jsonPath("$.sexe",CoreMatchers.is(patientDto.getSexe())));
    }

    @Test
    void updatePatient() {
    }

    @Test
    void deletePatientById() {
    }
}