package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnalyseRepository extends JpaRepository<Analyse,Long> {
    List<Analyse> findByDeletedFalse();
    Optional<Analyse> findByIdAndDeletedFalse(Long id);
}
