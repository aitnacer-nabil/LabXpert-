package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Result;
import com.aitnacer.LabXpert.entity.TestStandardValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TestRepositoryTest {
    @Autowired
    TestRepository testRepository;
    @Autowired
    TestStandardValueRepository testStandardValueRepository;
    @Autowired
    ResultRepository resultRepository;

    @Test
    @DisplayName("given testbjen when save return savedobject with id")
    public void save(){
        TestStandardValue testStandardValue= TestStandardValue.builder()
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
        com.aitnacer.LabXpert.entity.Test test  = com.aitnacer.LabXpert.entity.Test.builder()
                .nom("XYW")
                .testStandardValue(testStandardValueSaved)
                .result(resultSaved)
                .build();
        com.aitnacer.LabXpert.entity.Test testSaved = testRepository.save(test);
        assertThat(testSaved).isNotNull();
        assertThat(testSaved.getId()).isGreaterThan(0);
        testStandardValueSaved.setTest(test);
        System.out.println("-----------------------testStandardValueSaved----------------------");
        Optional<TestStandardValue> testStandardValue1 = testStandardValueRepository.findById(testStandardValueSaved.getId());
        System.out.println(testStandardValue1.get());
        System.out.println(testStandardValue1.get().getTest());
        System.out.println("------------------------------Test------------------------------------");
        Optional<com.aitnacer.LabXpert.entity.Test> testOptional = testRepository.findById(testSaved.getId());
        System.out.println(testOptional.get());
        System.out.println(testOptional.get().getResult());
        System.out.println(testOptional.get().getTestStandardValue());
        System.out.println("----------------------------Result----------------------------------");
        Optional<Result> resultOptional = resultRepository.findById(resultSaved.getId());
        System.out.println(resultOptional.get());
        System.out.println("-------------------------------------------------------------------");
    }
}