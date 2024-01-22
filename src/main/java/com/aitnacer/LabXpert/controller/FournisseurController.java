package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.FournisseurDTO;
import com.aitnacer.LabXpert.dtos.echantillon.EchantillonDto;
import com.aitnacer.LabXpert.dtos.patient.PatientDto;
import com.aitnacer.LabXpert.dtos.patient.PatientEchantillonDto;
import com.aitnacer.LabXpert.service.IFournisseurService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.BASE_API_URL +"fournisseur")
@AllArgsConstructor
public class FournisseurController {

    IFournisseurService fournisseurService;

    @GetMapping
    public ResponseEntity<List<FournisseurDTO>> getAllPatient(){
        return ResponseEntity.ok(fournisseurService.getAllFournisseur());
    }
    @GetMapping("/{id}")
    public ResponseEntity<FournisseurDTO> getPatiientById(@PathVariable(name = "id") Long id) {
        FournisseurDTO fournisseurDTO = fournisseurService.getFournisseurById(id);
        return ResponseEntity.ok(fournisseurDTO);
    }

    @PostMapping
    public ResponseEntity<FournisseurDTO> createPatient( @RequestBody FournisseurDTO fournisseurDTO) {
        FournisseurDTO fournisseurDTO1 = fournisseurService.createFournisseur(fournisseurDTO);
        return new ResponseEntity<>(fournisseurDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FournisseurDTO> updatePatient(@PathVariable("id") Long id,  @RequestBody FournisseurDTO fournisseurDTO)  {
        return ResponseEntity.ok(fournisseurService.updateFournisseur(id, fournisseurDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable("id") Long id)  {
        fournisseurService.deleteFournisseur(id);
        return ResponseEntity.ok("Reactif with id: " + id + " has been deleted successfully!");
    }
}
