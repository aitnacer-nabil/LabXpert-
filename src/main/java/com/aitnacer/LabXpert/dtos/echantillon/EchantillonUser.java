package com.aitnacer.LabXpert.dtos.echantillon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EchantillonUser {
    private  Long id;
    List<EchantillonNoUserIdDto> echantillons;
}
