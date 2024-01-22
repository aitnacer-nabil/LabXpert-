package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.FournisseurDTO;

import java.util.List;

public interface IFournisseurService {
    public FournisseurDTO createFournisseur(FournisseurDTO fournisseurDTO);
    public FournisseurDTO getFournisseurById(Long id);
    public FournisseurDTO updateFournisseur(FournisseurDTO fournisseurDTO);
    public Boolean deleteFournisseur(FournisseurDTO fournisseurDTO);
    public List<FournisseurDTO> getAllFournisseur();
}
