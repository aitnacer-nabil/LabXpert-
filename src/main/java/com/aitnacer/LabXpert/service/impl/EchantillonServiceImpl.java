package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.dtos.echantillon.*;
import com.aitnacer.LabXpert.dtos.patient.PatientDto;
import com.aitnacer.LabXpert.dtos.patient.PatientEchantillonDto;
import com.aitnacer.LabXpert.dtos.patient.PatientIdDto;
import com.aitnacer.LabXpert.dtos.reactif.ReactifAnalyseDto;
import com.aitnacer.LabXpert.entity.*;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.*;
import com.aitnacer.LabXpert.service.IEchantillonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class EchantillonServiceImpl implements IEchantillonService {
    private final EchantillonRepository echantillonRepository;
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;
    private final ReactifRepository reactifRepository;
    private final ReactifAnalyseRepository reactifAnalyseRepository;


    @Override
    public List<EchantillonResponseDto> getAllEchantillons() {
        List<Echantillon> echantillons = echantillonRepository.findByDeletedFalse();

        return echantillons.stream().map((element) -> {
            System.out.println(element);
            return modelMapper.map(element, EchantillonResponseDto.class);
        }).collect(Collectors.toList());
    }

    @Override
    public EchantillonDto getEchantillonsById(Long id) {

        Echantillon echantillon = echantillonRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ApiException("Echantillon not found with  ", id));
        return modelMapper.map(echantillon, EchantillonDto.class);
    }

    @Override
    public EchantillonDto createEchantillon(EchantillonRequestDto echantillonRequestDto) {
        log.info("Echantillon DTO {}", echantillonRequestDto);
        if(echantillonRequestDto.getReactifAnalyses().size() <= 0){
            throw new ApiException("empty List of reactifAnalyses  ",HttpStatus.NOT_ACCEPTABLE);
        }
        List<ReactifAnalyse> reactifAnalyses = echantillonRequestDto.getReactifAnalyses().stream().map(reactifAnalyseDto -> {
            Reactif reactif = reactifRepository.findByIdReactifAndAndDeletedFalse(reactifAnalyseDto.getReactifIdReactif()).orElseThrow(() -> new ApiException("Reactif not found with  ", reactifAnalyseDto.getReactifIdReactif()));
            reactif.subQte(reactifAnalyseDto.getQuantite());
           Reactif reactifSaved = reactifRepository.save(reactif);
            ReactifAnalyse reactifAnalyse = ReactifAnalyse.builder().reactif(reactifSaved).quantite(reactifAnalyseDto.getQuantite()).build();
          //  reactifAnalyseDto1.setReactifIdReactif(reactif.getIdReactif());
            log.info("Stream reactifAnalyseDto {} ",reactifAnalyseDto);
            return reactifAnalyseRepository.save(reactifAnalyse) ;
        }).collect(Collectors.toList());
        Echantillon echantillon = modelMapper.map(echantillonRequestDto, Echantillon.class);
        Utilisateur utilisateur = userRepository.findByIdAndDeletedFalse(echantillonRequestDto.getUtilisateurId()).orElseThrow(() -> new ApiException("utilisateur not found with  ", echantillonRequestDto.getUtilisateurId()));
        Patient patient = patientRepository.findByIdAndDeletedFalse(echantillonRequestDto.getPatientId()).orElseThrow(() -> new ApiException("patient not found with  ", echantillonRequestDto.getPatientId()));

        echantillon.setEchantillonCode(generateCode());
        echantillon.setUtilisateur(utilisateur);
        echantillon.setAssigned(true);
        echantillon.setPatient(patient);
        echantillon.setReactifAnalyses(reactifAnalyses);

        Echantillon echantillonSaved = echantillonRepository.save(echantillon);

        return modelMapper.map(echantillonSaved, EchantillonDto.class);
    }

    @Override
    public EchantillonDto updateEChantillon(Long id, EchantillonDto echantillonRequestDto) {
        Echantillon echantillon = echantillonRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ApiException("Echantillon not found with  ", id));
        System.out.println(echantillon);
        if (echantillon.getUtilisateur().getId() != echantillonRequestDto.getUtilisateurId()) {
            Utilisateur utilisateur = userRepository.findByIdAndDeletedFalse(echantillonRequestDto.getUtilisateurId()).orElseThrow(() -> new ApiException("utilisateur not found with  ", echantillonRequestDto.getUtilisateurId()));
            echantillon.setUtilisateur(utilisateur);
        }
        if (echantillon.getPatient().getId() != echantillonRequestDto.getPatientId()) {
            Patient patient = patientRepository.findByIdAndDeletedFalse(echantillonRequestDto.getPatientId()).orElseThrow(() -> new ApiException("patient not found with  ", echantillonRequestDto.getPatientId()));
            echantillon.setPatient(patient);
        }
        echantillon.setDateDeReception(echantillonRequestDto.getDateDeReception());
        echantillon.setUpdatedAt(LocalDateTime.now());
        return modelMapper.map(echantillonRepository.save(echantillon), EchantillonDto.class);
    }

    @Override
    public void deleteEchantillon(Long id) {
        Echantillon echantillon = echantillonRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ApiException("Echantillon not found with  ", id));
        echantillon.setDeleted(false);
        echantillonRepository.save(echantillon);
    }

    @Override
    public PatientEchantillonDto getEchantillonsByPatientId(long patientId) {
        Patient patient = patientRepository.findByIdAndDeletedFalse(patientId).orElseThrow(() -> new ApiException("Patient not found with  ", patientId));
        List<Echantillon> echantillons = echantillonRepository.findByPatient_IdAndDeletedFalse(patientId);
        PatientEchantillonDto patientEchantillonDto = PatientEchantillonDto.builder()
                .patient(modelMapper.map(patient, PatientIdDto.class))
                .echantillons(echantillons.stream().map((element) -> modelMapper.map(element, EchantillonNoPatientIdDto.class)).collect(Collectors.toList()))
                .build();
        return patientEchantillonDto;
    }

    @Override
    public EchantillonDto getEchantillonsByPatientIdAndCode(long patientId, String echantillonCode) {
        Patient patient = patientRepository.findByIdAndDeletedFalse(patientId).orElseThrow(() -> new ApiException("Patient not found with  ", patientId));
        Echantillon echantillon = echantillonRepository.findByPatient_IdAndDeletedFalseAndEchantillonCode(patientId, echantillonCode).orElseThrow(() -> new ApiException("echantillon not found with Code :" + echantillonCode, HttpStatus.BAD_REQUEST));
        return modelMapper.map(echantillon, EchantillonDto.class);
    }

    @Override
    public EchantillonUser getEchantillonByUserId(long userId) {
        userRepository.findByIdAndDeletedFalse(userId).orElseThrow(() -> new ApiException("utilisateur not found with  ", userId));
        List<Echantillon> echantillons = echantillonRepository.findByUtilisateur_IdAndDeletedFalse(userId);
        List<EchantillonNoUserIdDto> echantillonNoUserIdDtos = echantillons.stream().map((element) -> modelMapper.map(element, EchantillonNoUserIdDto.class)).collect(Collectors.toList());
        return EchantillonUser.builder().id(userId).echantillons(echantillonNoUserIdDtos).build();
    }

    @Override
    public EchantillonDto getEchantillonByUserIdByCode(long userId, String echantillonCode) {
        userRepository.findByIdAndDeletedFalse(userId).orElseThrow(() -> new ApiException("utilisateur not found with  ", userId));
        Echantillon echantillon = echantillonRepository.findByUtilisateur_IdAndDeletedFalseAndEchantillonCode(userId, echantillonCode).orElseThrow(() -> new ApiException("echantillon not found with Code :" + echantillonCode, HttpStatus.BAD_REQUEST));
        return modelMapper.map(echantillon, EchantillonDto.class);
    }

    private static String generateCode() {
        StringBuilder codeBuilder = new StringBuilder();

        codeBuilder.append("NAB");
        // Add a random numeric part (you can customize this part)
        int numericPart = (int) (Math.random() * 10000);
        codeBuilder.append(String.format("%04d", numericPart));
        return codeBuilder.toString();
    }
}
