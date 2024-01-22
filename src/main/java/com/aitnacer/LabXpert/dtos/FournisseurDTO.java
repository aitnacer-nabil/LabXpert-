package com.aitnacer.LabXpert.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FournisseurDTO {
    private Long idFournisseur;
    private String nom;
    private String adresse;
    private String tel;
    private Boolean deleted=false;
}
