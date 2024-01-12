package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
