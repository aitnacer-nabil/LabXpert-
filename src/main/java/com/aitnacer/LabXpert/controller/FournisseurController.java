package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.FournisseurDTO;
import com.aitnacer.LabXpert.service.IFournisseurService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(Constant.BASE_API_URL +"fournisseur")
@AllArgsConstructor
public class FournisseurController {

    IFournisseurService fournisseurService;

    @GetMapping
    public ResponseEntity<List<FournisseurDTO>> getAllFournisseur(){
        return ResponseEntity.ok(fournisseurService.getAllFournisseur());
    }
    @GetMapping("/{id}")
    public ResponseEntity<FournisseurDTO> getFournisseurById(@PathVariable(name = "id") Long id) {
        FournisseurDTO fournisseurDTO = fournisseurService.getFournisseurById(id);
        return ResponseEntity.ok(fournisseurDTO);
    }

    @PostMapping
    public ResponseEntity<FournisseurDTO> createFournisseur( @RequestBody FournisseurDTO fournisseurDTO) {
        FournisseurDTO fournisseurDTO1 = fournisseurService.createFournisseur(fournisseurDTO);
        return new ResponseEntity<>(fournisseurDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FournisseurDTO> updateFournisseur(@PathVariable("id") Long id,  @RequestBody FournisseurDTO fournisseurDTO)  {
        return ResponseEntity.ok(fournisseurService.updateFournisseur(id, fournisseurDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id)  {
        Map<String, Object> response = new HashMap<>();
        fournisseurService.deleteFournisseur(id);
        response.put("success", true);
        response.put("message", "Fournisseur with id: " + id + " has been deleted successfully!");
        return ResponseEntity.ok(response);
    }
}
