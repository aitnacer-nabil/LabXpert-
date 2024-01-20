package com.aitnacer.LabXpert.dtos;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO for {@link com.aitnacer.LabXpert.entity.TypeAnalyse}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeAnalyseDto implements Serializable {
    @NotNull
    Long id;
}