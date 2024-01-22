package com.aitnacer.LabXpert;


import com.aitnacer.LabXpert.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class LabXpertApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(LabXpertApplication.class, args);
    }



    @Override


    public void run(String... args) throws Exception {



//        Doctor doctor = new Doctor();
//        doctor.setNom("NomDoctor");
//        doctor.setPrenom("PrenomDoctor");
//        doctor.setAdresse("AdresseDoctor");
//        doctor.setTelephone("9876543210");
//        doctor.setSexe(EnumSexe.FEMAL);
//        doctor.setUserName("DoctorUser");
//        doctor.setPassword("DoctorPass");
//
//         Création d'un patient
//        Patient patient = new Patient();
//        patient.setNom("NomPatient");
//        patient.setPrenom("PrenomPatient");
//        patient.setAdresse("AdressePatient");
//        patient.setTelephone("5555555555");
//        patient.setSexe(EnumSexe.MALE);
//        // Création d'un technicien
//        Technicien technicien = new Technicien();
//        technicien.setNom("NomTechnicien");
//        technicien.setPrenom("PrenomTechnicien");
//        technicien.setAdresse("AdresseTechnicien");
//        technicien.setTelephone("1111111111");
//        technicien.setSexe(EnumSexe.FEMAL);
//        technicien.setUserName("TechnicienUser");
//        technicien.setPassword("TechnicienPass");
//        Echantillon echantillon = new Echantillon();
//        echantillon.setEchantillonCode("ECE1212");
//        echantillon.setTechenicien(technicien);
//        echantillon.setDateDeReception(LocalDateTime.now());
//        echantillon.setPatient(patient);
//        patient.setEchantillons(new ArrayList<>());
//        patient.getEchantillons().add(echantillon);
//        technicien.setEchantillons(new ArrayList<>());
//        technicien.getEchantillons().add(echantillon);
//        Analyse analyse = new Analyse();
//        analyse.setDateDebut(LocalDateTime.now()); // Utilisez la date et l'heure actuelles ou des valeurs appropriées
//        analyse.setCommentaire("Analyse en cours");
//        analyse.setStatus(AnalyseStatus.EN_ATTENTE);
//        analyse.setDoctor(doctor);
//        doctor.setAnalyse(analyse);
//        analyse.setNom("Homologie XYZ");
//        TypeAnalyse typeAnalyse = new TypeAnalyse();
//        typeAnalyse.setNom("TypeXYZ");
//        analyse.setTypeAnalyses(new ArrayList<>());
//        analyse.getTypeAnalyses().add(typeAnalyse);
//        typeAnalyse.setAnalyse(analyse);
//
//        Test test = new Test();
//        test.setNom("TestXYZ");
//        test.setTypeAnalyse(typeAnalyse);
//
//        TestStandardValue testStandardValue = new TestStandardValue();
//        testStandardValue.setUnite("UnitéXYZ"); // Remplacez par l'unité appropriée
//        testStandardValue.setMinValue(5.0f); // Remplacez par la valeur minimale appropriée
//        testStandardValue.setMaxValue(10.0f);
//        Result resultat = new Result();
//        resultat.setValue(8.5f);
//        test.setTestStandardValue(testStandardValue);
//        test.setResult(resultat);//
//        test.setTypeAnalyse(typeAnalyse);// Remplacez par la valeur maximale appropriée
//        analyseRepository.save(analyse);

    }


}
