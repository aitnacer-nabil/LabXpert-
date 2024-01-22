package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.scheduling.SchedulingRequestDto;
import com.aitnacer.LabXpert.entity.*;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.*;
import com.aitnacer.LabXpert.service.ISimpleAnalyseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class SimpleAnalyseServiceImpl implements ISimpleAnalyseService {
    private SimpleAnalyseRepository simpleAnalyseRepository;
    private UserRepository userRepository;
    private EchantillonRepository echantillonRepository;
    private AnalyseRepository analyseRepository;
    @Override
    public SimpleAnalyse createSimpleAnalyse(SchedulingRequestDto schedulingRequestDto) {
        Echantillon echantillon = echantillonRepository.findByIdAndDeletedFalse(schedulingRequestDto.getEchantillonId()).orElseThrow(() -> new ApiException("Echantillon not found with  ", schedulingRequestDto.getEchantillonId()));
        Utilisateur utilisateur = userRepository.findByIdAndDeletedFalse(schedulingRequestDto.getUtilisateurId()).orElseThrow(new ApiException(String.format("No User fond for this   %s",schedulingRequestDto.getUtilisateurId()), HttpStatus.BAD_REQUEST));
        Analyse analyse =  analyseRepository.findByIdAndDeletedFalse(schedulingRequestDto.getAnalyseId()).orElseThrow(new ApiException("Analyse not found with",schedulingRequestDto.getAnalyseId()));
        SimpleAnalyse simpleAnalyse = SimpleAnalyse.builder()
                .echantillon(echantillon)
                .utilisateur(utilisateur)
                .analyse(analyse)
                .results(new ArrayList<>())
                .status(AnalyseStatus.EN_ATTENTE)
                .dateDebut(schedulingRequestDto.getDateDebut())
                .build();
        if(!schedulingRequestDto.getCommentaire().isEmpty()){
            simpleAnalyse.setCommentaire(schedulingRequestDto.getCommentaire());
        }

        return simpleAnalyseRepository.save(simpleAnalyse);
    }

    @Override
    public SimpleAnalyse getSimpleAnalyseById(Long id) {
        return simpleAnalyseRepository.findById(id).orElseThrow(()->new ApiException("No SimpleAnalyse found with this id",id));
    }

    @Override
    public List<SimpleAnalyse> getAllSimpleAnalyses() {
        return simpleAnalyseRepository.findAll();
    }

    @Override
    public List<SimpleAnalyse> getSimpleAnalysesByUtilisateur(Utilisateur utilisateur) {
        //TODO getSimpleAnalysesByUtilisateur
        return null;
    }
}
