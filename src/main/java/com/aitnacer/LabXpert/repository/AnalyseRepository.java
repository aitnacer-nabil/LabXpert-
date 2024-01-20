package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AnalyseRepository extends JpaRepository<Analyse,Long> {
    List<Analyse> findByDeletedFalse();
    Optional<Analyse> findByIdAndDeletedFalse(Long id);


}
