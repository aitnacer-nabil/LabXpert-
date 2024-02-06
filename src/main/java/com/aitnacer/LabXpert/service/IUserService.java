package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.UtilisateurDto;
import com.aitnacer.LabXpert.entity.Utilisateur;

import java.util.List;

public interface IUserService {
    List<UtilisateurDto> getAllUtilisateur();
    UtilisateurDto getUtilisateurById(Long id);
    UtilisateurDto createUtilisateur(UtilisateurDto administrateurDto);
    UtilisateurDto updateUtilisateur(Long id , UtilisateurDto administrateurDto);
    void deleteUtilisateur(Long id);
    Utilisateur loadUserByEmail(String userName);


}
