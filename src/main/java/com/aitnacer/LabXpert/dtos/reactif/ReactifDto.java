package com.aitnacer.LabXpert.dtos.reactif;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Min;
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
    @Min(1)
    int quantite;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime dateExpiration;
    Long fournisseurIdFournisseur;
    boolean deleted;
}
//TODO handl validation rectifanalyse