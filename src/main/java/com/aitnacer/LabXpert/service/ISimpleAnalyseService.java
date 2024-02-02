package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.scheduling.SchedulingRequestDto;
import com.aitnacer.LabXpert.entity.SimpleAnalyse;
import com.aitnacer.LabXpert.entity.Utilisateur;

import java.util.List;

public interface ISimpleAnalyseService {

    SimpleAnalyse createSimpleAnalyse(SchedulingRequestDto schedulingRequestDto);

    SimpleAnalyse getSimpleAnalyseById(Long id);

    List<SimpleAnalyse> getAllSimpleAnalyses();
    SimpleAnalyse updateSimpleAnalyse(SimpleAnalyse simpleAnalyse);

    List<SimpleAnalyse> getSimpleAnalysesByUtilisateur(Utilisateur utilisateur);
    List<SimpleAnalyse> getAllSimpleAnalyseHasResult();
}
