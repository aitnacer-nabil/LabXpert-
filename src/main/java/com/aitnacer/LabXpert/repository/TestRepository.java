package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByDeletedFalse();

    Optional<Test> findByIdAndDeletedFalse(Long id);

    @Query("SELECT t from Test t "
            + "where t.typeAnalyse.analyse.id = :analyseId "
            + "AND t.typeAnalyse.id = :typeAnalyseId "+
            "and t.deleted = false "
    )
    List<Test> findALLByTypeAnalyseAndAnalyse(@Param("analyseId") long analyseId,@Param("typeAnalyseId") long typeAnalyseId);

}
