package com.aitnacer.LabXpert.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "test", uniqueConstraints = {@UniqueConstraint(columnNames = "nom", name = "uk_test_nom")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom",unique = true)
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    private String nom;
    @NotNull(message = "unit value cannot be null")
    private String unit;
    @NotNull(message = "Minimum value cannot be null")
    private float minValue;
    @NotNull(message = "Maximum value cannot be null")
    private float maxValue;
    @ManyToOne
    @JoinColumn(name = "type_analyse_id")
    private TypeAnalyse typeAnalyse;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}

