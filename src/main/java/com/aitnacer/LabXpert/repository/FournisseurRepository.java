package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Fournisseur;
import com.aitnacer.LabXpert.entity.Reactif;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    List<Fournisseur> findByDeletedFalse();
    Optional<Fournisseur> findByIdFournisseurAndDeletedFalse(Long id);
}
