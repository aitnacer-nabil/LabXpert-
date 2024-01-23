package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.AnalyseDto;

import com.aitnacer.LabXpert.service.IAnalyseService;
import com.aitnacer.LabXpert.service.IEchantillonService;
import com.aitnacer.LabXpert.service.ITestService;
import com.aitnacer.LabXpert.service.ITypeAnalyseService;
import com.aitnacer.LabXpert.service.impl.AnalyseServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
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

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AnalyseController.class)
class AnalyseControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AnalyseServiceImpl analyseService;
    @MockBean
    private ITypeAnalyseService typeAnalyseService;
    @MockBean
    private ITestService testService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllAnalyse() throws Exception {
        AnalyseDto analyseDto = AnalyseDto.builder()
                .id(1L)
                .nom("salma")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        AnalyseDto analyseDto1 = AnalyseDto.builder()
                .id(1L)
                .nom("salma")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        List<AnalyseDto> analyseDtos = Arrays.asList(analyseDto, analyseDto1);

        when(analyseService.getAllAnalyses()).thenReturn(analyseDtos);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/analyse")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nom").value("salma"))


                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        Assertions.assertNotNull(response);


    }

    @Test
    void getAnalyseById() throws Exception {
        AnalyseDto analyseDto = AnalyseDto.builder()
                .id(1L)
                .nom("salma")
                .createdAt(LocalDateTime.now())
                .build();

        Long patientId = 1L;
        when(analyseService.getAnalyseById(patientId)).thenReturn(analyseDto);

        ResultActions response = mockMvc.perform(get("/api/v1/analyse/{id}", patientId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", CoreMatchers.is(analyseDto.getNom())));

    }

    @Test
    void createAnalyse() throws Exception {
        //given

        AnalyseDto analyseDto = AnalyseDto.builder()
                .id(1L)
                .nom("salma")
                .createdAt(LocalDateTime.now())
                .build();

        given(analyseService.createAnalyse(any()))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions responce = mockMvc.perform(post("/api/v1/analyse").
                contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(analyseDto))
        );

        //then verify
        responce.andExpect(status().isCreated())
                //.andExpect(jsonPath("$.id", CoreMatchers.is(patientDto.getId())))
                .andExpect(jsonPath("$.nom", CoreMatchers.is(analyseDto.getNom())));

    }

    @Test
    void updateAnalyse() throws Exception {

        Long id = 1L;
        String nom = "Complete Blood Count";
        AnalyseDto analyseDto = new AnalyseDto();
        analyseDto.setNom(nom);

        AnalyseDto updatedAnalyse = new AnalyseDto();
        updatedAnalyse.setId(id);
        updatedAnalyse.setNom(nom);

        when(analyseService.updateAnalyse(eq(id), any(AnalyseDto.class))).thenReturn(updatedAnalyse);

        // Act & Assert
        mockMvc.perform(put("/api/v1/analyse/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(analyseDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(updatedAnalyse)));
    }

    // @SneakyThrows
    @Test
    void deleteAnalyseById() throws Exception {

        Long Id = 1L;
        doNothing().when(analyseService).deleteAnalyse(Id);

        ResultActions response = mockMvc.perform(delete("/api/v1/analyse/{id}", Id)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }
}


