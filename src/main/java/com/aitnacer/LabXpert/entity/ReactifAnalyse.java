package com.aitnacer.LabXpert.entity;

import com.aitnacer.LabXpert.exception.common.ApiException;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.*;


@Entity
@Table(name="reactifsanalyses")
@NoArgsConstructor
public class ReactifAnalyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reactif reactif;

    private int quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reactif getReactif() {
        return reactif;
    }

    public void setReactif(Reactif reactif) {
        this.reactif = reactif;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        if (reactif.getQuantite()!= 0 && reactif.getQuantite() < quantite){
            throw new ApiException("Insufficient Stock Contact Responsable", HttpStatus.NOT_ACCEPTABLE);
        }

        this.quantite = quantite;
        reactif.subQte(quantite);
    }
}