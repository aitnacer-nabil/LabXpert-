package com.aitnacer.LabXpert.dtos;

import com.aitnacer.LabXpert.dtos.EchantillonDto;
import com.aitnacer.LabXpert.dtos.TypeAnalyseDto;
import com.aitnacer.LabXpert.dtos.UtilisateurDto;
import com.aitnacer.LabXpert.entity.Analyse;
import com.aitnacer.LabXpert.entity.AnalyseStatus;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link Analyse}
 */
@Value
public class AnalyseDto implements Serializable {
    Long id;
    LocalDateTime dateDebut;
    String Commentaire;
    String nom;
    EchantillonDto echantillon;
    AnalyseStatus status;
    List<TypeAnalyseDto> typeAnalyses;
    UtilisateurDto utilisateur;
    boolean deleted;
}