package com.aitnacer.LabXpert.entity;

import com.aitnacer.LabXpert.exception.common.ApiException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="reactifs", uniqueConstraints = {@UniqueConstraint(name = "nom_unique", columnNames = {"nom"})})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class Reactif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReactif;
    @Column(name = "nom",unique = true)
    private String nom;
    private String description;
    private int quantite;
    private LocalDateTime dateExpiration;
    @ManyToOne
    private Fournisseur fournisseur;
    @Column(name="is_deleted")
    private boolean deleted;

   public void subQte(int qte){
       if (quantite < qte && quantite != 0){
           throw new ApiException("Insufficient Stock Contact Responsable", HttpStatus.NOT_ACCEPTABLE);
       }
       this.quantite -= qte;
   }
    public void addQte(int qte){

        this.quantite += qte;
    }
}