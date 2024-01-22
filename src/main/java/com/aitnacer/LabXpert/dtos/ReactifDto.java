package com.aitnacer.LabXpert.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.Reactif}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactifDto implements Serializable {
    Long idReactif;
    String nom;
    String description;
    int quantite;
    LocalDateTime dateExpiration;
    Long fournisseurIdFournisseur;
    Boolean deleted;
}