package com.aitnacer.LabXpert.repository;


import com.aitnacer.LabXpert.entity.TestStandardValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestStandardValueRepository extends JpaRepository<TestStandardValue,Long> {
    List<TestStandardValue> findByDeletedFalse();
    Optional<TestStandardValue> findByIdAndDeletedFalse(Long id);
}
