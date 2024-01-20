package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.TypeAnalyseDto;
import com.aitnacer.LabXpert.entity.Analyse;
import com.aitnacer.LabXpert.entity.TypeAnalyse;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.AnalyseRepository;
import com.aitnacer.LabXpert.repository.TypeAnalyseRepository;
import com.aitnacer.LabXpert.service.ITypeAnalyseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TypeAnalyseServiceImpl implements ITypeAnalyseService {
    private final TypeAnalyseRepository typeAnalyseRepository;
    private final AnalyseRepository analyseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TypeAnalyseDto> getAllTypeAnalyses() {
        return typeAnalyseRepository.findByDeletedFalse()
                .stream()
                .map(typeAnalyse -> modelMapper.map(typeAnalyse, TypeAnalyseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TypeAnalyseDto getTypeAnalyseById(Long id) {
        TypeAnalyse typeAnalyse = typeAnalyseRepository.findByIdAndDeletedFalse(id).orElseThrow(new ApiException("TypeAnalyse not found with ",id));
        return modelMapper.map(typeAnalyse, TypeAnalyseDto.class);
    }

    @Override
    public TypeAnalyseDto createTypeAnalyse( TypeAnalyseDto typeAnalyseDto) {
        validateTypeAnalyseDto(typeAnalyseDto);
        TypeAnalyse typeAnalyse = modelMapper.map(typeAnalyseDto, TypeAnalyse.class);
        TypeAnalyse savedTypeAnalyse = typeAnalyseRepository.save(typeAnalyse);
        return modelMapper.map(savedTypeAnalyse, TypeAnalyseDto.class);
    }

    @Override
    public TypeAnalyseDto updateTypeAnalyse(Long id,  TypeAnalyseDto typeAnalyseDto) {
        validateTypeAnalyseDto(typeAnalyseDto);

        TypeAnalyse existingTypeAnalyse = typeAnalyseRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException("TypeAnalyse not found with  ", id));
       if( existingTypeAnalyse.getAnalyse().getId() != typeAnalyseDto.getAnalyseId()){
           Analyse analyse  = analyseRepository.findByIdAndDeletedFalse(typeAnalyseDto.getAnalyseId()).orElseThrow(() -> new ApiException("Analyse not found with  ", id));
            existingTypeAnalyse.setAnalyse(null);
            existingTypeAnalyse.setAnalyse(analyse);
        }
        TypeAnalyse updatedTypeAnalyse = typeAnalyseRepository.save(existingTypeAnalyse);
        return modelMapper.map(updatedTypeAnalyse, TypeAnalyseDto.class);
    }

    @Override
    public void deleteTypeAnalyse(Long id) {
        TypeAnalyse typeAnalyse = typeAnalyseRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException("TypeAnalyse not found with  ", id));

        typeAnalyse.setDeleted(true);
        typeAnalyseRepository.save(typeAnalyse);
    }

    private void validateTypeAnalyseDto(TypeAnalyseDto typeAnalyseDto) {
        // Perform custom validation logic here
        if (typeAnalyseDto.getNom() == null || typeAnalyseDto.getNom().isEmpty()) {
            throw new ValidationException("Name cannot be null or empty");
        }

        if (typeAnalyseDto.getAnalyseId() == null) {
            throw new ValidationException("Analyse ID cannot be null");
        }
    }
}
