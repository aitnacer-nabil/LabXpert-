package com.aitnacer.LabXpert.dtos.analyse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalyseRequestDto {
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    String nomAnalyse;
    @NotNull
    List<TypeAnalyseDRequestDtoto> typeAnalyseDRequestDtotos;
}
