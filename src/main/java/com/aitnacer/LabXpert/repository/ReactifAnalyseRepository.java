package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Echantillon;
import com.aitnacer.LabXpert.entity.ReactifAnalyse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReactifAnalyseRepository extends JpaRepository<ReactifAnalyse,Long> {

    Optional<ReactifAnalyse> findById(Long id);
}
