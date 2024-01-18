package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AnalyseRepositoryTest {
    @Autowired
    AnalyseRepository analyseRepository;
    @Autowired
    TypeAnalyseRepository typeAnalyseRepository;
    @Autowired
    TestRepository testRepository;
    @Autowired
    TestStandardValueRepository testStandardValueRepository;
    @Autowired
    ResultRepository resultRepository;

    @Test
    @DisplayName("given Analyse object then save reutn savedObject")
    public void save() {
        TestStandardValue testStandardValue = TestStandardValue.builder()
                .maxValue(4)
                .minValue(1)
                .unite("mg/s")
                .build();

        TestStandardValue testStandardValueSaved = testStandardValueRepository.save(testStandardValue);
        assertThat(testStandardValueSaved).isNotNull();
        assertThat(testStandardValueSaved.getId()).isGreaterThan(0);
        Result result = Result.builder().result(1.5).build();
        Result resultSaved = resultRepository.save(result);
        assertThat(resultSaved).isNotNull();
        assertThat(resultSaved.getId()).isGreaterThan(0);
        com.aitnacer.LabXpert.entity.Test test = com.aitnacer.LabXpert.entity.Test.builder()
                .nom("XYW")
                .testStandardValue(testStandardValueSaved)
                .result(resultSaved)
                .build();
        com.aitnacer.LabXpert.entity.Test testSaved = testRepository.save(test);
        assertThat(testSaved).isNotNull();
        assertThat(testSaved.getId()).isGreaterThan(0);
        testStandardValueSaved.setTest(test);
        TestStandardValue testStandardValue2 = TestStandardValue.builder()
                .maxValue(2000)
                .minValue(23333)
                .unite("g/dl")
                .build();

        TestStandardValue testStandardValueSaved2 = testStandardValueRepository.save(testStandardValue2);
        assertThat(testStandardValueSaved2).isNotNull();
        assertThat(testStandardValueSaved2.getId()).isGreaterThan(0);
        Result result2 = Result.builder().result(200).build();
        Result resultSaved2 = resultRepository.save(result2);
        assertThat(resultSaved2).isNotNull();
        assertThat(resultSaved2.getId()).isGreaterThan(0);
        com.aitnacer.LabXpert.entity.Test test2 = com.aitnacer.LabXpert.entity.Test.builder()
                .nom("HOMOLOGIE")
                .testStandardValue(testStandardValueSaved2)
                .result(resultSaved2)
                .build();
        com.aitnacer.LabXpert.entity.Test testSaved2 = testRepository.save(test2);
        assertThat(testSaved2).isNotNull();
        assertThat(testSaved2.getId()).isGreaterThan(0);
        testStandardValueSaved2.setTest(test2);
        List<com.aitnacer.LabXpert.entity.Test> testList = new ArrayList<>();
        testList.add(testSaved);
        testList.add(testSaved2);
        TypeAnalyse typeAnalyse = TypeAnalyse.builder()
                .tests(testList)
                .nom("NUMERATION")
                .build();
        TypeAnalyse typeAnalyseSaved = typeAnalyseRepository.save(typeAnalyse);
        testSaved.setTypeAnalyse(typeAnalyseSaved);
        testSaved2.setTypeAnalyse(typeAnalyseSaved);
        List<TypeAnalyse> typeAnalyses = new ArrayList<>();
        typeAnalyses.add(typeAnalyseSaved);
        Analyse analyse = Analyse.builder()
                .Commentaire("not normal")
                .typeAnalyses(typeAnalyses)
                .dateDebut(LocalDateTime.now())
                .status(AnalyseStatus.EN_ATTENTE)
                .nom("HOMO GENERAl")
                .build();
        Analyse analyseSaved = analyseRepository.save(analyse);
        typeAnalyseSaved.setAnalyse(analyseSaved);


        System.out.println("-----------------------testStandardValueSaved----------------------");
        Optional<TestStandardValue> testStandardValue1 = testStandardValueRepository.findById(testStandardValueSaved.getId());
        System.out.println(testStandardValue1.get());
        System.out.println(testStandardValue1.get().getTest());
        System.out.println("------------------------------Test  1 ------------------------------------");
        com.aitnacer.LabXpert.entity.Test testOptional = testRepository.findById(testSaved.getId()).get();
        System.out.println(testOptional);
        System.out.println(testOptional.getResult());
        System.out.println(testOptional.getTestStandardValue());
        System.out.println(testOptional.getTypeAnalyse());
        System.out.println("----------------------------Result   1----------------------------------");
        Optional<Result> resultOptional = resultRepository.findById(resultSaved.getId());
        System.out.println(resultOptional.get());
        System.out.println("-------------------------------------------------------------------");
        System.out.println("------------------------------Test  2------------------------------------");
        Optional<com.aitnacer.LabXpert.entity.Test> testOptional2 = testRepository.findById(testSaved2.getId());
        System.out.println(testOptional2.get());
        System.out.println(testOptional2.get().getResult());
        System.out.println(testOptional2.get().getTestStandardValue());
        System.out.println(testOptional2.get().getTypeAnalyse());
        System.out.println("----------------------------Result  2 ---------------------------------");
        Optional<Result> resultOptional2 = resultRepository.findById(resultSaved2.getId());
        System.out.println(resultOptional2.get());
        System.out.println("---------------------------Type Analyse-------------------------------");
        TypeAnalyse typeAnalyse1 = typeAnalyseRepository.findById(typeAnalyseSaved.getId()).get();
        System.out.println(typeAnalyse1);
        System.out.println(typeAnalyse1.getTests());
        System.out.println(typeAnalyse1.getAnalyse());
        System.out.println("-------------------------------------------------------------------");
        System.out.println("--------------------------- Analyse-------------------------------");
        Analyse analyse1 = analyseRepository.findById(analyseSaved.getId()).get();
        System.out.println(analyse1);
        System.out.println(analyse1.getTypeAnalyses());
        System.out.println("-------------------------------------------------------------------");

    }
}