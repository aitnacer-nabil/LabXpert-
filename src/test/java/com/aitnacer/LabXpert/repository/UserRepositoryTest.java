package com.aitnacer.LabXpert.repository;

import com.aitnacer.LabXpert.entity.EnumSexe;
import com.aitnacer.LabXpert.entity.UserRole;
import com.aitnacer.LabXpert.entity.Utilisateur;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    ///Junit test for save utilisateur
    @Test
    @DisplayName("Junit test for save Utilisateur")
    public void givenUtilisateur_whenSave_thenReturnSavedEmployee(){
        //given or precondition
        Utilisateur utilisateur = Utilisateur.builder()
                .nom("nabil")
                .prenom("ait")
                .sexe(EnumSexe.MALE)
                .role(UserRole.RESPONSABLE)
                .Adresse("hello")
                .userName("nabil")
                .telephone("213213")
                .password("12345")
                .build();
        //when action or behaviour

        Utilisateur utilisateurSaved = userRepository.save(utilisateur);

        //then verify the out
       assertThat(utilisateurSaved).isNotNull();
       assertThat(utilisateurSaved.getId()).isGreaterThan(0);
       System.out.println(utilisateurSaved);

    }
    @Test
    @DisplayName("Junit test for getting all utilisateur")
    public void getAllUtilisateur(){
        Utilisateur utilisateur1 = Utilisateur.builder()
                .nom("nabil")
                .prenom("ait")
                .sexe(EnumSexe.MALE)
                .role(UserRole.RESPONSABLE)
                .Adresse("hello")
                .userName("nabil")
                .telephone("213213")
                .password("12345")
                .build();
        Utilisateur utilisateur2 = Utilisateur.builder()
                .nom("nabil 1" )
                .prenom("ait 1")
                .sexe(EnumSexe.MALE)
                .role(UserRole.RESPONSABLE)
                .Adresse("hello")
                .userName("nabil")
                .telephone("213213")
                .password("12345")
                .build();
        Utilisateur utilisateur3 = Utilisateur.builder()
                .nom("nabil 2")
                .prenom("ait 2")
                .sexe(EnumSexe.MALE)
                .role(UserRole.RESPONSABLE)
                .Adresse("hello")
                .userName("nabil")
                .telephone("213213")
                .password("12345")
                .build();
        Stream.of(utilisateur2,utilisateur3,utilisateur1).forEach(user ->{
             Utilisateur utilisateur =  userRepository.save(user);
            assertThat(utilisateur).isNotNull();
            assertThat(utilisateur.getId()).isGreaterThan(0);
            System.out.println(utilisateur);
        });
        List<Utilisateur>  utilisateurs = userRepository.findByDeletedFalse();
        assertThat(utilisateurs.size()).isGreaterThan(0);

    }
}