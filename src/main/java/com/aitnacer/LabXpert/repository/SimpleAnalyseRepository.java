package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.SimpleAnalyse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimpleAnalyseRepository extends JpaRepository<SimpleAnalyse,Long> {

    List<SimpleAnalyse> findByHasResultTrue();
}
