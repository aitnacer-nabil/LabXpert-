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
        .prenom("jari")
        .Adresse("rue 7tanger")
        .telephone("09876655")
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
                .prenom("jari")
                .Adresse("rue 7tanger")
                .telephone("09876655")
                .sexe(EnumSexe.valueOf("FEMAL"))
                .build();
        Patient patient2= Patient.builder()
                .nom("kawtar")
                .prenom("jari")
                .Adresse("rue 7tanger")
                .telephone("09876655")
                .sexe(EnumSexe.valueOf("FEMAL"))
                .build();
        Patient patient3= Patient.builder()
                .nom("kawtar")
                .prenom("jari")
                .Adresse("rue 7tanger")
                .telephone("09876655")
                .sexe(EnumSexe.valueOf("FEMAL"))
                .build();
        Patient patient4= Patient.builder()
                .nom("kawtar")
                .prenom("jari")
                .Adresse("rue 7tanger")
                .telephone("09876655")
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
                .prenom( "MIAH" )
                .Adresse( "mohosinmiah1610" )
                .telephone ( "09888777" )
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
                .prenom( "MIAH" )
                .Adresse( "mohosinmiah1610" )
                .telephone ( "09888777" )
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
        // Donné : objet de configuration ou condition préalable
        Patient patientInitial = patientRepository.save(Patient.builder().build());
        // Quand : Action ou comportement que nous allons tester
        Patient getPatient= patientRepository.findById(patientInitial.getId()).orElseThrow(null);
            getPatient.setNom( "MISE À JOUR MOHOSINE" );
            getPatient.setPrenom( "Nom" );
            getPatient.setAdresse( "fes" );
            getPatient.setTelephone( "12345" );
            getPatient.setSexe(EnumSexe.valueOf("MALE"));
       Patient updatePatient = patientRepository.save(getPatient);
        // Ensuite : Vérifiez la sortie ou le résultat attendu
        assertThat(updatePatient).isNotNull();
        assertThat(updatePatient.getTelephone()).isEqualTo("12345" );


    }
    // Test JUnit pour l'opération delete patient
    @Test
    @DisplayName("Test JUnit pour l'opération de delete patient")
    public  void  gavePatientObject_whenDelete_thenRemovePatient() {
        Patient patient = Patient.builder()
                .nom( "alah" )
                .prenom( "kol" )
                .Adresse( "casarue4" )
                .telephone ( "09888777" )
                .sexe (EnumSexe.valueOf("MALE"))
                .build();
        // Donné : objet de configuration ou condition préalable
        Patient patientinit = patientRepository.save(patient);
        // Quand : Action ou comportement que nous allons tester
       // PatientRepository.deleteById(patientinit.getId());
        Optional<Patient> deletePatient = patientRepository.findByIdAndDeletedFalse(patientinit.getId());
        // Ensuite : Vérifiez la sortie ou le résultat attendu
        assertThat(deletePatient).isEmpty();
    }



}