package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.AdministrateurDto;
import com.aitnacer.LabXpert.entity.Administrateur;
import com.aitnacer.LabXpert.repository.AdministrateurRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdministrateurService {

    private final AdministrateurRepository administrateurRepository;
    private final ModelMapper modelMapper;


    public List<AdministrateurDto> getAllAdministrateurs(){
        List<Administrateur> administrateurs = administrateurRepository.findByDeletedFalse();
        return  administrateurs.stream().map(administrateur -> modelMapper.map(administrateur, AdministrateurDto.class)).collect(Collectors.toList());
    }
    public AdministrateurDto getAdministrateurById(Long id) {
        //TODO add exption not found
        Administrateur administrateur = administrateurRepository.findByIdAndDeletedFalse(id).orElse(null);
        return modelMapper.map(administrateur, AdministrateurDto.class);
    }
    public AdministrateurDto createAdministrateur(AdministrateurDto administrateurDto){
        // TODO verification for administrateur
        Administrateur administrateur = modelMapper.map(administrateurDto, Administrateur.class);
        Administrateur administrateurSaved  = administrateurRepository.save(administrateur);
        return  modelMapper.map(administrateurSaved, AdministrateurDto.class);

    }
    public AdministrateurDto updateAdministrateur(Long id , AdministrateurDto administrateurDto){
        //TODO trow exption not found and validation
        Administrateur existingAdmin = administrateurRepository.findByIdAndDeletedFalse(id).orElse(null);
        //TODO validation
        existingAdmin.setPrenom(administrateurDto.getPrenom());
        existingAdmin.setNom(administrateurDto.getNom());
        existingAdmin.setAdresse(administrateurDto.getAdresse());
        existingAdmin.setUserName(administrateurDto.getUserName());
        existingAdmin.setPassword(administrateurDto.getPassword());
        existingAdmin.setTelephone(administrateurDto.getTelephone());
        existingAdmin.setSexe(administrateurDto.getSexe());
        Administrateur updatedAdministrateur = administrateurRepository.save(existingAdmin);
        updatedAdministrateur.setId(id);
        return modelMapper.map(updatedAdministrateur, AdministrateurDto.class);


    }
}
