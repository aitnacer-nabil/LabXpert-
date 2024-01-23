package com.aitnacer.LabXpert.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "type_analyse", uniqueConstraints = {@UniqueConstraint(columnNames = "nom", name = "uk_type_analyse_nom")})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeAnalyse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nom;
    @ManyToOne
    @JoinColumn(name = "analyse_id")
    private Analyse analyse;
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;
    @CreationTimestamp
    @Column(name = "type_analyse_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "type_analyse_updated_at")
    private LocalDateTime updatedAt;

}
