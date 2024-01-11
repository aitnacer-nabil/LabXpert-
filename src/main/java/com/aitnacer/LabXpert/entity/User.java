package com.aitnacer.LabXpert.entity;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String userName;
    private String modeDePass;
    private String prenom;
    private String address;
    private String telephone;


}
