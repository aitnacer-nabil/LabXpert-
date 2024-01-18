package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class EchantillonRepositoryTest {
    @Autowired
    EchantillonRepository echantillonRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    void getAllEchantillons() {

    }

    @Test
    void getEchantillonsById() {
    }

    @Test
    @DisplayName("givenEchantile then save and return Echantillon DTO")
    void createEchantillon() {
        Utilisateur utilisateur = Utilisateur.builder()
                .nom("nabil")
                .prenom("ait nacer")
                .sexe(EnumSexe.MALE)
                .role(UserRole.TECHNICIEN)
                .Adresse("hello")
                .userName("nabil")
                .telephone("0612341256")
                .password("12345")
                .build();
        //when action or behaviour

        Utilisateur utilisateurSaved = userRepository.save(utilisateur);
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
        Echantillon echantillon = Echantillon.builder()
                .dateDeReception(LocalDateTime.now())
                .echantillonCode("ABC123")
                .patient(patientsaved)
                .utilisateur(utilisateurSaved)
                .build();
        Echantillon echantillon2 =Echantillon.builder()
                .dateDeReception(LocalDateTime.now().minusDays(2))
                .echantillonCode("PQR789")
                .utilisateur(utilisateur)
                .patient(patient)
                .build();
        Echantillon echantillonSaved = echantillonRepository.save(echantillon);
        Echantillon echantillonSaved2 = echantillonRepository.save(echantillon2);
        assertThat(echantillonSaved).isNotNull();
        System.out.println(echantillonSaved);
        System.out.println(echantillonSaved.getUtilisateur()+" " +echantillonSaved.getUtilisateur().getEchantillons());
        System.out.println(echantillonSaved.getPatient());
        System.out.println("-------------------------------------------------");
        System.out.println(userRepository.findByIdAndDeletedFalse(utilisateurSaved.getId())+" " +utilisateur.getEchantillons());
        System.out.println(patientRepository.findByIdAndDeletedFalse(patientsaved.getId()));
        System.out.println("-------------------------------------------------");

        assertThat(echantillonSaved2).isNotNull();
        System.out.println(echantillonSaved2);
        System.out.println(echantillonSaved2.getUtilisateur()+" " +echantillonSaved2.getUtilisateur().getEchantillons());

        System.out.println(echantillonSaved2.getPatient());




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