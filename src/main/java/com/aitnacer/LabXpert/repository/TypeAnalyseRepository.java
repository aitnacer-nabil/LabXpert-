package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.TypeAnalyse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeAnalyseRepository extends JpaRepository<TypeAnalyse,Long> {

    List<TypeAnalyse> findByDeletedFalse();
    Optional<TypeAnalyse> findByIdAndDeletedFalse(Long id);
}
