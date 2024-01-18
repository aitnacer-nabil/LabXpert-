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

@DataJpaTest
class EchantillonRepositoryTest {
    @Autowired
    EchantillonRepository echantillonRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    UserRepository userRepository;
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
        List<Analyse> analyses = new ArrayList<>();
        analyses.add(analyseSaved);
        echantillonSaved.setAnalyses(analyses);
        analyseSaved.setEchantillon(echantillonSaved);
        analyseSaved.setUtilisateur(utilisateurSaved);

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
        System.out.println("---------------------------echantillonSaved----------------------------------");

        System.out.println(echantillonSaved);
        System.out.println(echantillonSaved.getUtilisateur()+" " +echantillonSaved.getUtilisateur().getEchantillons());
        System.out.println(echantillonSaved.getPatient());
        System.out.println(echantillonSaved.getAnalyses());
        System.out.println("-----------------------utilisateurSaved---------------------------------------------");
        System.out.println(userRepository.findByIdAndDeletedFalse(utilisateurSaved.getId())+" " +utilisateur.getEchantillons());
        System.out.println("-----------------------patientsaved---------------------------------------------");
       // System.out.println(patientRepository.findByIdAndDeletedFalse(patientsaved.getId()));
        System.out.println("-------------------------------------------------");

        assertThat(echantillonSaved2).isNotNull();
        System.out.println("-----------------------echantillonSaved2--------------------------");
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