package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
