package com.aitnacer.LabXpert.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EchantillonRepositoryTest {
    @Autowired
    EchantillonRepository echantillonRepository;
    @Test
    void getAllEchantillons() {
    }

    @Test
    void getEchantillonsById() {
    }

    @Test
    @DisplayName("givenEchantile then save and return Echantillon DTO")
    void createEchantillon() {

    }

    @Test
    void updateEChantillon() {
    }

    @Test
    void deleteEchantillon() {
    }
    @Test
    void findByDeletedFalse() {
    }

    @Test
    void findByIdAndDeletedFalse() {
    }
}