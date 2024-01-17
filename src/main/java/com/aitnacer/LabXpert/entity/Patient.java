package com.aitnacer.LabXpert.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "patients")
@NoArgsConstructor
public class Patient extends UtilisateurInfo {

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private List<Echantillon> echantillons;


}
