package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Patient;
import com.aitnacer.LabXpert.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient>findByDeletedFalse();
    Optional<Patient> findByIdAndDeletedFalse(Long id);
}
