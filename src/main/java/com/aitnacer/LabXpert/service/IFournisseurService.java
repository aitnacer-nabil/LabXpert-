package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.FournisseurDTO;

import java.util.List;

public interface IFournisseurService {
    public FournisseurDTO createFournisseur(FournisseurDTO fournisseurDTO);
    public FournisseurDTO getFournisseurById(Long id);
    public FournisseurDTO updateFournisseur(long id,FournisseurDTO fournisseurDTO);
    public void deleteFournisseur(long id);
    public List<FournisseurDTO> getAllFournisseur();
}
