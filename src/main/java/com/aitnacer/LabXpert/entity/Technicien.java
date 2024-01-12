package com.aitnacer.LabXpert.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;



@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Entity
@Table(name = "techniciens")
public class Technicien extends Utilisateur{
    private String userName;
    private String password;

    public Technicien() {
        this.setRole(UserRole.TECHNICIEN);
    }
    @OneToMany(mappedBy = "techenicien",fetch = FetchType.LAZY)
    private List<Echantillon> echantillons;
}
