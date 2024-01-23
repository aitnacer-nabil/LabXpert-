package com.aitnacer.LabXpert.entity;

import com.aitnacer.LabXpert.exception.common.ApiException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.persistence.*;


@Entity
@Table(name="reactifsanalyses")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReactifAnalyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reactif reactif;

    private int quantite;



}