package com.aitnacer.LabXpert.entity;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link TypeAnalyse}
 */
@Value
public class TypeAnalyseDto implements Serializable {
    Long id;
    String nom;
    Long analyseId;
    boolean deleted;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}