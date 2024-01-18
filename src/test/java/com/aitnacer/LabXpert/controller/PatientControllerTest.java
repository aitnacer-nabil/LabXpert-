package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.PatientDto;
import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.Patient;
import com.aitnacer.LabXpert.service.IPatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
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
    void createUser() throws Exception {
        //given
        PatientDto patientDto=PatientDto.builder()
                .nom("salma")
                .prenom("SAI")
                .Adresse("quartie casa ")
                .telephone("9885456")
                .sexe(EnumSexe.valueOf("MALE"))
                .build();
        BDDMockito.given(patientService.createPatient(ArgumentMatchers.any(PatientDto.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        //when
         ResultActions responce= mockMvc.perform(post("/api/v1/patient").
                contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patientDto))
        );


        //then verify
        responce.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(patientDto.getNom())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prenom",CoreMatchers.is(patientDto.getPrenom())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Adresse",CoreMatchers.is(patientDto.getAdresse())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.telephone",CoreMatchers.is(patientDto.getTelephone())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sexe",CoreMatchers.is(patientDto.getSexe())));
    }

    @Test
    void updatePatient() {
    }

    @Test
    void deletePatientById() {
    }
}