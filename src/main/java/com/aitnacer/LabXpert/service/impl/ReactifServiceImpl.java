package com.aitnacer.LabXpert.service.impl;



import com.aitnacer.LabXpert.dtos.ReactifDto;
import com.aitnacer.LabXpert.entity.Fournisseur;
import com.aitnacer.LabXpert.entity.Reactif;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.FournisseurRepository;
import com.aitnacer.LabXpert.repository.ReactifRepository;
import com.aitnacer.LabXpert.service.IReactif;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReactifServiceImpl implements IReactif {

    ReactifRepository reactifRepository;
    ModelMapper modelMapper;
    FournisseurRepository fournisseurRepository;


    @Override
    public ReactifDto createRecatif(ReactifDto reactifdto) {
        validate(reactifdto);
        Reactif reactif = modelMapper.map(reactifdto, Reactif.class);
        Reactif  saved = reactifRepository.save(reactif);


        return modelMapper.map(reactif, ReactifDto.class);
    }

    @Override
    public ReactifDto updatedRectif(ReactifDto reactifdto) {
        validate(reactifdto);
        Reactif reactif = reactifRepository.findByIdReactifAndAndDeletedFalse(reactifdto.getIdReactif()).orElseThrow(() -> new ApiException("Reactif not found with  ", reactifdto.getIdReactif()));
        Fournisseur fournisseur = fournisseurRepository.findByIdFournisseurAndDeletedFalse(reactifdto.getFournisseurIdFournisseur()).orElseThrow(() -> new ApiException("Reactif not found with  ", reactifdto.getIdReactif()));
// Update fields
        reactif.setNom(reactifdto.getNom());
        reactif.setDescription(reactifdto.getDescription());
        reactif.setQuantite(reactifdto.getQuantite());
        reactif.setDateExpiration(reactifdto.getDateExpiration());
        reactif.setFournisseur(fournisseur);
        reactif.setDeleted(reactifdto.getDeleted());

        // Save the updated Reactif
        Reactif updatedReactif = reactifRepository.save(reactif);

        // Convert and return the updated ReactifDto
        return modelMapper.map(reactif, ReactifDto.class);
    }

    @Override
    public void deleteRectif(long id) {
        Reactif reactif = reactifRepository.findByIdReactifAndAndDeletedFalse(id).orElseThrow(() -> new ApiException("Reactif not found with  ", id));
        reactif.setDeleted(true);
        reactifRepository.save(reactif);

    }

    @Override
    public List<ReactifDto> getAllReactif() {
        List<Reactif> reactifs = reactifRepository.findByDeletedFalse();

        return reactifs.stream().map((element) -> modelMapper.map(element, ReactifDto.class)).collect(Collectors.toList());
    }

    @Override
    public ReactifDto getReactifById(Long id) {
        Reactif reactif = reactifRepository.findByIdReactifAndAndDeletedFalse(id).orElseThrow(() -> new ApiException("Reactif not found with  ", id));
        return modelMapper.map(reactif, ReactifDto.class);
    }
    private void validate(ReactifDto reactifDto){

        if (reactifDto == null) {
            throw new ApiException("ReactifDto cannot be null");
        }

        validateStringField(reactifDto.getNom(), "Nom");
        validateStringField(reactifDto.getDescription(), "Description");

        validateNonStringField(reactifDto.getQuantite(), "Quantite");
        validateNonStringField(reactifDto.getDateExpiration(), "DateExpiration");
        validateNonStringField(reactifDto.getFournisseurIdFournisseur(),"FournisseurID");
    }
    private  void validateStringField(String value, String fieldName) throws ApiException {
        if (StringUtils.isBlank(value)) {
            throw new ApiException(fieldName + " cannot be empty or blank");
        }
    }

    private  void validateNonStringField(Object value, String fieldName) throws ApiException {
        if (value == null) {
            throw new ApiException(fieldName + " cannot be null");
        }

        // Additional validation for specific types if needed
        if (value instanceof Integer && ((Integer) value) <= 0) {
            throw new ApiException(fieldName + " should be a positive integer");
        }

        // Add more specific validations for other types if needed
    }

}
