package com.aitnacer.LabXpert;


import com.aitnacer.LabXpert.entity.*;
import com.aitnacer.LabXpert.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabXpertApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LabXpertApplication.class, args);
	}
	@Autowired
	AdministrateurRepository administrateurRepository;
	@Override
	public void run(String... args) throws Exception {
		// Création d'un administrateur
//		Administrateur administrateur = new Administrateur();
//		administrateur.setNom("NomAdmin");
//		administrateur.setPrenom("PrenomAdmin");
//		administrateur.setAdresse("AdresseAdmin");
//		administrateur.setTelephone("0123456789");
//		administrateur.setSexe(EnumSexe.MALE);
//		administrateur.setUserName("AdminUser");
//		administrateur.setPassword("AdminPass");
//		System.out.println(administrateurRepository.save(administrateur));
//		//administrateurRepository.deleteById(1L);
//		administrateur.setPrenom("Updated Prenom");
//
//		System.out.println(administrateurRepository.save(administrateur));
		// Création d'un docteur
		Doctor doctor = new Doctor();
		doctor.setNom("NomDoctor");
		doctor.setPrenom("PrenomDoctor");
		doctor.setAdresse("AdresseDoctor");
		doctor.setTelephone("9876543210");
		doctor.setSexe(EnumSexe.FEMAL);
		doctor.setUserName("DoctorUser");
		doctor.setPassword("DoctorPass");

		// Création d'un patient
		Patient patient = new Patient();
		patient.setNom("NomPatient");
		patient.setPrenom("PrenomPatient");
		patient.setAdresse("AdressePatient");
		patient.setTelephone("5555555555");
		patient.setSexe(EnumSexe.MALE);
		// Création d'un technicien
		Technicien technicien = new Technicien();
		technicien.setNom("NomTechnicien");
		technicien.setPrenom("PrenomTechnicien");
		technicien.setAdresse("AdresseTechnicien");
		technicien.setTelephone("1111111111");
		technicien.setSexe(EnumSexe.FEMAL);
		technicien.setUserName("TechnicienUser");
		technicien.setPassword("TechnicienPass");


	}
}
