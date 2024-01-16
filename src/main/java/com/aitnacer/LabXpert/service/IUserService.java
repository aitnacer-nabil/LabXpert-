package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.UtilisateurDto;

import java.util.List;

public interface IUserService {
    List<UtilisateurDto> getAllUtilisateur();
    UtilisateurDto getUtilisateurById(Long id);
    UtilisateurDto createUtilisateur(UtilisateurDto administrateurDto);
    UtilisateurDto updateUtilisateur(Long id , UtilisateurDto administrateurDto);
    void deleteUtilisateur(Long id);


}
