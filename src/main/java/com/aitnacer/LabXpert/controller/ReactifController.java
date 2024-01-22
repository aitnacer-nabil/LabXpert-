package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.FournisseurDTO;
import com.aitnacer.LabXpert.dtos.ReactifDto;
import com.aitnacer.LabXpert.service.IReactifService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.BASE_API_URL +"reactif")
@AllArgsConstructor
public class ReactifController {

    IReactifService reactifService;
    @GetMapping
    public ResponseEntity<List<ReactifDto>> getAllPatient(){
        return ResponseEntity.ok(reactifService.getAllReactif());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReactifDto> getPatiientById(@PathVariable(name = "id") Long id) {
        ReactifDto reactifDto = reactifService.getReactifById(id);
        return ResponseEntity.ok(reactifDto);
    }

    @PostMapping
    public ResponseEntity<ReactifDto> createPatient( @RequestBody ReactifDto reactifDto) {
        ReactifDto reactifDto1 = reactifService.createRecatif(reactifDto);
        return new ResponseEntity<>(reactifDto1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReactifDto> updatePatient(@PathVariable("id") Long id,  @RequestBody ReactifDto reactifDto)  {
        return ResponseEntity.ok(reactifService.updatedRectif(id, reactifDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable("id") Long id)  {
        reactifService.deleteRectif(id);
        return ResponseEntity.ok("Reactif with id: " + id + " has been deleted successfully!");
    }
}
