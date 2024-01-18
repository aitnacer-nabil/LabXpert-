package com.aitnacer.LabXpert.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TypeAnalyseRepositoryTest {
    @Autowired
    TypeAnalyseRepository typeAnalyseRepository;

}