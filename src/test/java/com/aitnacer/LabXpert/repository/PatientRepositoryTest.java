package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.Patient;
import com.aitnacer.LabXpert.entity.Utilisateur;
import org.h2.index.Cursor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest  //pour tester l'anotation de jpa
class PatientRepositoryTest {
    @Autowired
    PatientRepository patientRepository;

    @Test
    void givenPatient(){
        //give :creation de l'objet et initialitation de varible et la configuration de test
        Patient patient=Patient.builder()
        .nom("kawtar")
        .prenom("khawla")
        .Adresse("rue 7tanger")
        .telephone( "0987654321")
        .sexe(EnumSexe.valueOf("FEMAL"))
        .build();

        //insert une patient dans un base de donnne
        Patient patientsaved = patientRepository.save(patient);
        //When Il s’agit souvent d’une méthode ou d’une fonction spécifique qui est testée.
        assertThat(patientsaved).isNotNull();
        assertThat(patientsaved.getId()).isGreaterThan(0);
        System.out.println(patientsaved);

    }
    @Test
    @DisplayName("Junit test for getting all patient")
    public void getAllPatient(){
        Patient patient1= Patient.builder()
                .nom("kawtar")
                .prenom("mouslim")
                .Adresse("rue 7tanger")
                .telephone("0987665509")
                .sexe(EnumSexe.valueOf("FEMAL"))
                .build();
        Patient patient2= Patient.builder()
                .nom("kawtar")
                .prenom("salmipm")
                .Adresse("rue 7tanger")
                .telephone("0987654321")
                .sexe(EnumSexe.valueOf("FEMAL"))
                .build();
        Patient patient3= Patient.builder()
                .nom("kawtar")
                .prenom("jariKPL")
                .Adresse("rue 7tanger")
                .telephone("0987665556")
                .sexe(EnumSexe.valueOf("FEMAL"))
                .build();
        Patient patient4= Patient.builder()
                .nom("kawtar")
                .prenom("jariLMP")
                .Adresse("rue 7tanger")
                .telephone("0987665535")
                .sexe(EnumSexe.valueOf("FEMAL"))
                .build();
        Stream.of(patient1,patient2,patient3,patient4).forEach(patient -> {
            Patient patients = patientRepository.save(patient);
            assertThat(patients).isNotNull();
            assertThat(patients.getId()).isGreaterThan(0);
            System.out.println(patient);
        });
        List<Patient> patientList = patientRepository.findByDeletedFalse();
        assertThat(patientList.size()).isGreaterThan(0);

    }
    @BeforeEach
    public  void  setupTestData () {
        // Étant donné : objet de configuration ou condition préalable
        Patient patient = Patient.builder()
                .nom( "MOHOSIN" )
                .prenom( "MIAHlmm" )
                .Adresse( "mohosinmiah1610" )
                .telephone ( "1234567890" )
                .sexe (EnumSexe.valueOf("MALE"))
                .build();
    }
    // Test JUnit pour l'opération de sauvegarde des patient
    @Test
    @DisplayName("Test JUnit pour l'opération de sauvegarde des patients")
    public  void  gavePatientObject_whenSave_thenReturnSavePatient () {
        // Quand : Action du comportement que nous allons tester
        Patient patient = Patient.builder()
                .nom( "MOHOSIN" )
                .prenom( "hilalil" )
                .Adresse( "mohosinmiah1610" )
                .telephone ( "0987654321" )
                .sexe (EnumSexe.valueOf("MALE"))
                .build();
       Patient savePatient  = patientRepository.save(patient);
        // Ensuite : Vérifiez la sortie
        assertThat(savePatient).isNotNull();
        assertThat(savePatient.getId()).isGreaterThan( 0 );
    }
    // Test JUnit pour obtenir l'opération d'obtention de la liste des patient
    @Test
    @DisplayName("Test JUnit pour l'opération update du patient")
    public void   gavePatientObject_whenUpdate_thenPatientObject (){


    }
    // Test JUnit pour l'opération delete patient
    @Test
    @DisplayName("Test JUnit pour l'opération de delete patient")
    public  void  gavePatientObject_whenDelete_thenRemovePatient() {
        Patient patient = Patient.builder()

                .nom( "alah" )
                .prenom( "lkjhfds" )
                .Adresse( "casarue4" )
                .telephone ( "0988877767" )
                .sexe (EnumSexe.MALE)
                .build();
        // Donné : objet de configuration ou condition préalable
        Patient patientinit = patientRepository.save(patient);
        // Quand : Action ou comportement que nous allons tester
       // PatientRepository.deleteById(patientinit.getId());
        Optional<Patient> deletePatient = patientRepository.findByIdAndDeletedFalse(patientinit.getId());
        // Ensuite : Vérifiez la sortie ou le résultat attendu
        assertThat(deletePatient).isNotNull();
    }



}