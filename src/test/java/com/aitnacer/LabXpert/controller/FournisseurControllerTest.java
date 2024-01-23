package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.FournisseurDTO;
import com.aitnacer.LabXpert.entity.Fournisseur;
import com.aitnacer.LabXpert.service.impl.FournisseurServiceImpl;
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

@WebMvcTest(FournisseurController.class)
class FournisseurControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FournisseurServiceImpl fournisseurService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllFournisseur() throws Exception {
        FournisseurDTO fournisseurDTO = FournisseurDTO.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")
                .build();
        FournisseurDTO fournisseurDTO1 = FournisseurDTO.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")
                .build();
        List<FournisseurDTO> fournisseurDTOList= Arrays.asList(fournisseurDTO, fournisseurDTO1);

        when(fournisseurService.getAllFournisseur()).thenReturn(fournisseurDTOList);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fournisseur/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].idFournisseur").value(1))
                .andExpect(jsonPath("$[0].nom").value("salma"))
                .andExpect(jsonPath("$[0].adresse").value("casa"))
                .andExpect(jsonPath("$[0].tel").value("1234567"))

                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        Assertions.assertNotNull(response);
    }

    @Test
    void getFournisseurById() throws Exception {
        FournisseurDTO fournisseurDTO = FournisseurDTO.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")
                .build();

        when(fournisseurService.getFournisseurById(1L)).thenReturn(fournisseurDTO);

        ResultActions response = mockMvc.perform(get("/api/v1/fournisseur/{id}",1L)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", CoreMatchers.is(fournisseurDTO.getNom())))
                .andExpect(jsonPath("$.adresse", CoreMatchers.is(fournisseurDTO.getAdresse())))
                .andExpect(jsonPath("$.tel", CoreMatchers.is(fournisseurDTO.getTel())));
    }

    @Test
    void createFournisseur() throws Exception {
        FournisseurDTO fournisseurDTO1 = FournisseurDTO.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")
                .build();

        given(fournisseurService.createFournisseur(ArgumentMatchers.any()))
                .willAnswer((invocation)-> invocation.getArgument(0));
        ResultActions responce= mockMvc.perform(post("/api/v1/fournisseur").
                contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fournisseurDTO1))
        );
        responce.andExpect(status().isCreated())

                .andExpect(jsonPath("$.nom", CoreMatchers.is(fournisseurDTO1.getNom())))
                .andExpect(jsonPath("$.adresse",CoreMatchers.is(fournisseurDTO1.getAdresse())))
                .andExpect(jsonPath("$.tel",CoreMatchers.is(fournisseurDTO1.getTel())));

    }

    @Test
    void updateFournisseur() throws Exception {
        FournisseurDTO fournisseurDTO = FournisseurDTO.builder()
                .idFournisseur(1L)
                .nom("salma")
                .adresse("casa")
                .tel("1234567")
                .build();
        Long patientid = 1L;
        when(fournisseurService.updateFournisseur(patientid,fournisseurDTO)).thenReturn(fournisseurDTO);

        ResultActions response = mockMvc.perform(put("/api/v1/patient/{id}", patientid)
                        .contentType(MediaType.APPLICATION_JSON)
                .contentType(objectMapper.writeValueAsString(fournisseurDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", CoreMatchers.is(fournisseurDTO.getNom())))

                .andExpect(jsonPath("$.adresse", CoreMatchers.is(fournisseurDTO.getAdresse())))
                .andExpect(jsonPath("$.tel", CoreMatchers.is(fournisseurDTO.getTel())));


    }

    @Test
    void deleteFournisseurById() throws Exception {
        Long fournisseurId = 1L;
        doNothing().when(fournisseurService).deleteFournisseur(fournisseurId);

        ResultActions response = mockMvc.perform(delete("/api/v1/fournisseur/{id}", fournisseurId)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }
}