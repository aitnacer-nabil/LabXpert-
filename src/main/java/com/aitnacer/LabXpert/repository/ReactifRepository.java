package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Echantillon;
import com.aitnacer.LabXpert.entity.Reactif;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReactifRepository extends JpaRepository<Reactif,Long> {
    List<Reactif> findByDeletedFalse();
    Optional<Reactif> findByIdReactifAndAndDeletedFalse(Long id);

}
