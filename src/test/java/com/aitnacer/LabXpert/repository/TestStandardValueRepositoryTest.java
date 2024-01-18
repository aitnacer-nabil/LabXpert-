package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.TestStandardValue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TestStandardValueRepositoryTest {
    @Autowired
    TestStandardValueRepository testStandardValueRepository;

    @Test
    @DisplayName("given TestStandardValueobj when Save return savedObject")
    public void save(){
        TestStandardValue testStandardValue= TestStandardValue.builder()
                .maxValue(4)
                .minValue(1)
                .unite("mg/s")
                .build();

        TestStandardValue testStandardValueSaved = testStandardValueRepository.save(testStandardValue);
        assertThat(testStandardValueSaved).isNotNull();
        assertThat(testStandardValueSaved.getId()).isGreaterThan(0);
        System.out.println(testStandardValueSaved);
    }

}