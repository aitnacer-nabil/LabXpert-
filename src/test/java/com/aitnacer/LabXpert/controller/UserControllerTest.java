package com.aitnacer.LabXpert.controller;


import com.aitnacer.LabXpert.dtos.UtilisateurDto;
import com.aitnacer.LabXpert.dtos.patient.PatientDto;
import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.UserRole;
import com.aitnacer.LabXpert.entity.Utilisateur;
import com.aitnacer.LabXpert.service.IEchantillonService;
import com.aitnacer.LabXpert.service.impl.UserServiceImpl;
import com.aitnacer.LabXpert.utils.Constant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;
    @MockBean
    private IEchantillonService iEchantillonService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Given UtilisatorTod Object when create Utilisateur then return Saved utilisateur")
    void getAllUser() throws Exception {
//        Utilisateur utilisateur1 = Utilisateur.builder()
//                .nom("nabil")
//                .prenom("ait nacer")
//                .sexe(EnumSexe.MALE)
//                .role(UserRole.RESPONSABLE)
//                .Adresse("hello")
//                .userName("nabil")
//                .telephone("0612341256")
//                .password("12345")
//                .build();
//        given(userService.createUtilisateur(ArgumentMatchers.any(UtilisateurDto.class)))
//                .willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
//        ResultActions response = mockMvc.perform(post(Constant.BASE_API_URL + "user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(utilisateur1))
//        );
//        response.andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.nom", CoreMatchers.is(utilisateur1.getNom())))
//                .andExpect(jsonPath("$.prenom", CoreMatchers.is(utilisateur1.getPrenom())))
//                .andExpect(jsonPath("$.sexe", CoreMatchers.is(utilisateur1.getSexe().name())))
//                .andExpect(jsonPath("$.role", CoreMatchers.is(utilisateur1.getRole().name())))
//                .andExpect(jsonPath("$.adresse", CoreMatchers.is(utilisateur1.getAdresse())))
//                .andExpect(jsonPath("$.userName", CoreMatchers.is(utilisateur1.getUserName())))
//                .andExpect(jsonPath("$.telephone", CoreMatchers.is(utilisateur1.getTelephone())));


    }
    @Test
    void getUserById() throws Exception {

        UtilisateurDto utilisateurDto = UtilisateurDto.builder()
                .nom("nabil")
                .prenom("ait nacer")
                .sexe(EnumSexe.MALE)
                .role(UserRole.RESPONSABLE)
                .Adresse("hello")
                .userName("nabil")
                .telephone("0612341256")
                .password("12345")
                .build();
        Long id = 1L;
        when(userService.getUtilisateurById(id)).thenReturn(utilisateurDto);

        ResultActions response = mockMvc.perform(get("/api/v1/user/{id}", id)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", CoreMatchers.is(utilisateurDto.getNom())))
                .andExpect(jsonPath("$.prenom", CoreMatchers.is(utilisateurDto.getPrenom())))
                .andExpect(jsonPath("$.sexe", CoreMatchers.is(utilisateurDto.getSexe().name())))
                .andExpect(jsonPath("$.role", CoreMatchers.is(utilisateurDto.getRole().name())))
                .andExpect(jsonPath("$.adresse", CoreMatchers.is(utilisateurDto.getAdresse())))
                .andExpect(jsonPath("$.userName", CoreMatchers.is(utilisateurDto.getUserName())))
                .andExpect(jsonPath("$.telephone", CoreMatchers.is(utilisateurDto.getTelephone())));


    }
    @Test
    void createUser() throws Exception {
        //given

        UtilisateurDto utilisateurDto = UtilisateurDto.builder()
                .nom("nabil")
                .prenom("ait nacer")
                .sexe(EnumSexe.MALE)
                .role(UserRole.RESPONSABLE)
                .Adresse("hello")
                .userName("nabil")
                .telephone("0612341256")
                .password("12345")
                .build();

        given(userService.createUtilisateur(ArgumentMatchers.any()))
                .willAnswer((invocation)-> invocation.getArgument(0));

        //when
        ResultActions responce= mockMvc.perform(post("/api/v1/user").
                contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(utilisateurDto))
        );

        //then verify
        responce.andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", CoreMatchers.is(utilisateurDto.getId())))
                .andExpect(jsonPath("$.nom", CoreMatchers.is(utilisateurDto.getNom())))
                .andExpect(jsonPath("$.prenom", CoreMatchers.is(utilisateurDto.getPrenom())))
                .andExpect(jsonPath("$.sexe", CoreMatchers.is(utilisateurDto.getSexe().name())))
                .andExpect(jsonPath("$.role", CoreMatchers.is(utilisateurDto.getRole().name())))
                .andExpect(jsonPath("$.adresse", CoreMatchers.is(utilisateurDto.getAdresse())))
                .andExpect(jsonPath("$.userName", CoreMatchers.is(utilisateurDto.getUserName())))
                .andExpect(jsonPath("$.telephone", CoreMatchers.is(utilisateurDto.getTelephone())));
    }
    @Test
    void updatePatient() throws Exception {
        UtilisateurDto utilisateurDto = UtilisateurDto.builder()
                .nom("nabil")
                .prenom("ait nacer")
                .sexe(EnumSexe.MALE)
                .role(UserRole.RESPONSABLE)
                .Adresse("hello")
                .userName("nabil")
                .telephone("0612341256")
                .password("12345")
                .build();
        Long id = 1L;
        when(userService.updateUtilisateur(id,utilisateurDto)).thenReturn(utilisateurDto);

        ResultActions response = mockMvc.perform(put("/api/v1/user/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(utilisateurDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", CoreMatchers.is(utilisateurDto.getNom())))
                .andExpect(jsonPath("$.prenom", CoreMatchers.is(utilisateurDto.getPrenom())))
                .andExpect(jsonPath("$.adresse", CoreMatchers.is(utilisateurDto.getAdresse())))
                .andExpect(jsonPath("$.telephone", CoreMatchers.is(utilisateurDto.getTelephone())))
                .andExpect(jsonPath("$.sexe", CoreMatchers.is(utilisateurDto.getSexe().name())));





    }
    @Test
    void deleteUsertById() throws Exception {

        Long id = 1L;
        doNothing().when(userService).deleteUtilisateur(id);

        ResultActions response = mockMvc.perform(delete("/api/v1/user/{id}", id)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }



}