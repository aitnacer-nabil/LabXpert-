package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.FournisseurDTO;
import com.aitnacer.LabXpert.entity.Fournisseur;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.FournisseurRepository;
import com.aitnacer.LabXpert.service.IFournisseurService;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FournisseurServiceImpl implements IFournisseurService {
    FournisseurRepository fournisseurRepository;
    ModelMapper modelMapper;

    @Override
    public FournisseurDTO createFournisseur(FournisseurDTO fournisseurDTO) {
        Fournisseur fournisseur = new Fournisseur();
        validateStringField(fournisseurDTO.getNom(), "nom");
        fournisseur.setNom(fournisseurDTO.getNom());
        validateStringField(fournisseurDTO.getAdresse(), "address");
        fournisseur.setAdresse(fournisseurDTO.getAdresse());
        validateStringField(fournisseurDTO.getNom(), "nom");
        fournisseur.setTel(fournisseurDTO.getTel());
        return modelMapper.map(fournisseurRepository.save(fournisseur), FournisseurDTO.class);
    }

    @Override
    public FournisseurDTO getFournisseurById(Long id) {
        Fournisseur fournisseur = fournisseurRepository.findByIdFournisseurAndDeletedFalse(id).orElseThrow(() -> new ApiException("Fournisseur not found with  ", id));
        return modelMapper.map(fournisseur, FournisseurDTO.class);
    }

    @Override
    public FournisseurDTO updateFournisseur(long id, FournisseurDTO fournisseurDTO) {
        Fournisseur fournisseur = fournisseurRepository.findByIdFournisseurAndDeletedFalse(id).orElseThrow(() -> new ApiException("Fournisseur not found with  ", id));

        validateStringField(fournisseurDTO.getNom(), "nom");
        fournisseur.setNom(fournisseurDTO.getNom());
        validateStringField(fournisseurDTO.getAdresse(), "address");
        fournisseur.setAdresse(fournisseurDTO.getAdresse());
        validateStringField(fournisseurDTO.getNom(), "nom");
        fournisseur.setTel(fournisseurDTO.getTel());
        return modelMapper.map(fournisseurRepository.save(fournisseur), FournisseurDTO.class);
    }

    @Override
    public void deleteFournisseur(long id) {
        Fournisseur fournisseur = fournisseurRepository.findByIdFournisseurAndDeletedFalse(id).orElseThrow(() -> new ApiException("Fournisseur not found with  ", id));
        fournisseur.setDeleted(true);
        fournisseurRepository.save(fournisseur);
    }

    @Override
    public List<FournisseurDTO> getAllFournisseur() {
        List<Fournisseur> fournisseurs = fournisseurRepository.findByDeletedFalse();
        return fournisseurs.stream().map((element) -> modelMapper.map(element, FournisseurDTO.class)).collect(Collectors.toList());
    }

    private void validateStringField(String value, String fieldName) throws ApiException {
        if (StringUtils.isBlank(value)) {
            throw new ApiException(fieldName + " cannot be empty or blank");
        }
    }
}
