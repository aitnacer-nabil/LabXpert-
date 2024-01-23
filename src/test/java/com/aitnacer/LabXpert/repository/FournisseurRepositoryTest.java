package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.Fournisseur;
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
@DataJpaTest
class FournisseurRepositoryTest {
@Autowired
    FournisseurRepository fournisseurRepository;
    @Test
    void givenFourniseur(){

        Fournisseur fournisseur=Fournisseur.builder()
                .nom("kawtar")
                .adresse("rue 7tanger")
                .tel( "0987654321")
                .build();


        Fournisseur fournisseursaved = fournisseurRepository.save(fournisseur);
        //When Il s’agit souvent d’une méthode ou d’une fonction spécifique qui est testée.
        assertThat(fournisseursaved).isNotNull();
        assertThat(fournisseursaved.getIdFournisseur()).isGreaterThan(0);
        System.out.println(fournisseursaved);

    }
    @Test
    @DisplayName("Junit test for getting all fourniseur")
    public void getAllFournisseur(){
        Fournisseur fournisseur= Fournisseur.builder()
                .nom("kawtar")
                .adresse("rue 7tanger")
                .tel("0987665509")
                .build();
        Fournisseur fournisseur1= Fournisseur.builder()
                .nom("kawtar")

                .adresse("rue 7tanger")
                .tel("0987654321")

                .build();
        Fournisseur fournisseur2= Fournisseur.builder()
                .nom("kawtar")

                .adresse("rue 7tanger")
                .tel("0987665556")

                .build();
        Fournisseur fournisseur3= Fournisseur.builder()
                .nom("kawtar")

                .adresse("rue 7tanger")
                .tel("0987665535")

                .build();
        Stream.of(fournisseur,fournisseur1,fournisseur2,fournisseur3).forEach(patient -> {
            Fournisseur fourniseurs = fournisseurRepository.save(fournisseur);
            assertThat(fourniseurs).isNotNull();
            assertThat(fourniseurs.getIdFournisseur()).isGreaterThan(0);
            System.out.println(fournisseur);
        });
        List<Fournisseur> fournisseurList = fournisseurRepository.findByDeletedFalse();
        assertThat(fournisseurList.size()).isGreaterThan(0);

    }
    @BeforeEach
    public  void  setupTestData () {
        // Étant donné : objet de configuration ou condition préalable
        Fournisseur fournisseur = Fournisseur.builder()
                .nom( "MOHOSIN" )
                .adresse( "mohosinmiah1610" )
                .tel ( "1234567890" )
                .build();
    }

    @Test
    @DisplayName("Test JUnit pour l'opération de sauvegarde des fournisseur")
    public  void  gavePatientObject_whenSave_thenReturnSavePatient () {
        // Quand : Action du comportement que nous allons tester
        Fournisseur fournisseur = Fournisseur.builder()
                .nom( "MOHOSIN" )

                .adresse( "mohosinmiah1610" )
                .tel ( "0987654321" )

                .build();
        Fournisseur saveFournisseur  = fournisseurRepository.save(fournisseur);
        // Ensuite : Vérifiez la sortie
        assertThat(saveFournisseur).isNotNull();
        assertThat(saveFournisseur.getIdFournisseur()).isGreaterThan( 0 );
    }

    @Test
    @DisplayName("Test JUnit pour l'opération update du fournisseur")
    public void   gavePatientObject_whenUpdate_thenFournisseurObject (){


    }
    // Test JUnit pour l'opération delete patient
    @Test
    @DisplayName("Test JUnit pour l'opération de delete patient")
    public  void  gaveFournisssurObject_whenDelete_thenRemoveFournisseur() {
        Fournisseur fournisseur = Fournisseur.builder()
                .nom( "alah" )
                .adresse( "casarue4" )
                .tel ( "0988877767" )
                .build();
        Fournisseur fournisseurtinit = fournisseurRepository.save(fournisseur);


        Optional<Fournisseur> deleteFournisseur = fournisseurRepository.findByIdFournisseurAndDeletedFalse(fournisseurtinit.getIdFournisseur());

        assertThat(deleteFournisseur).isNotNull();
    }


}