package com.aitnacer.LabXpert.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime dateExpiration;
    Long fournisseurIdFournisseur;
    Boolean deleted;
}