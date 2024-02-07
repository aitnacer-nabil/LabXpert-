package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.reactif.ReactifDto;
import com.aitnacer.LabXpert.service.IReactifService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(Constant.BASE_API_URL +"reactif")
@AllArgsConstructor
public class ReactifController {

    IReactifService reactifService;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('RESPONSABLE','TECHNICIEN')")
    public ResponseEntity<List<ReactifDto>> getAllPatient(){
        return ResponseEntity.ok(reactifService.getAllReactif());
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('RESPONSABLE','TECHNICIEN')")
    public ResponseEntity<ReactifDto> getReactifById(@PathVariable(name = "id") Long id) {
        ReactifDto reactifDto = reactifService.getReactifById(id);
        return ResponseEntity.ok(reactifDto);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<ReactifDto> createReactif( @RequestBody ReactifDto reactifDto) {
        ReactifDto reactifDto1 = reactifService.createRecatif(reactifDto);
        return new ResponseEntity<>(reactifDto1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<ReactifDto> updateReactif(@PathVariable("id") Long id,  @RequestBody ReactifDto reactifDto)  {
        return ResponseEntity.ok(reactifService.updatedRectif(id, reactifDto));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id)  {
        Map<String, Object> response = new HashMap<>();
        reactifService.deleteRectif(id);
        response.put("success", true);
        response.put("message", "Reactif with id: " + id + " has been deleted successfully!");
        return ResponseEntity.ok(response);
    }
}
