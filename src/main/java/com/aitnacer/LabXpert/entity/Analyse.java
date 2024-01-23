package com.aitnacer.LabXpert.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "analysis" ,uniqueConstraints = {@UniqueConstraint(columnNames = "nom", name = "uk_analysis_nom")})
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    private String nom;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;
    @CreationTimestamp
    @Column(name = "analyse_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "analyse_updated_at")
    private LocalDateTime updatedAt;

}
