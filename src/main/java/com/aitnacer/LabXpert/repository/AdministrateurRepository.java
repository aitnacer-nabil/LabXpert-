package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AdministrateurRepository  extends JpaRepository<Administrateur,Long> {
    List<Administrateur> findByDeletedFalse();
    Optional<Administrateur> findByIdAndDeletedFalse(Long id);
}
