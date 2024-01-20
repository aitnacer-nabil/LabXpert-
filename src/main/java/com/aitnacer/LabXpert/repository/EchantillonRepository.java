package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Echantillon;
import com.aitnacer.LabXpert.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EchantillonRepository extends JpaRepository<Echantillon,Long> {
    List<Echantillon> findByDeletedFalse();
    Optional<Echantillon> findByIdAndDeletedFalse(Long id);
    List<Echantillon> findByPatient_IdAndDeletedFalse(long patientId);
    Echantillon findByPatient_IdAndDeletedFalseAndEchantillonCode(long patientId,String echantillonCode);
}
