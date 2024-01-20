package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByDeletedFalse();
    Optional<Test> findByIdAndDeletedFalse(Long id);
}
