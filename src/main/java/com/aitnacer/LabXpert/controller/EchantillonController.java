package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.EchantillonRequestDto;
import com.aitnacer.LabXpert.dtos.EchantillonDto;
import com.aitnacer.LabXpert.service.IEchantillonService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.BASE_API_URL +"echantillons")
@AllArgsConstructor
public class EchantillonController {
    private final IEchantillonService echantillonService;
    @GetMapping
    public ResponseEntity<List<EchantillonDto>> getAllEchantillons() {
        List<EchantillonDto> echantillons = echantillonService.getAllEchantillons();
        return ResponseEntity.ok(echantillons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EchantillonDto> getEchantillonsById(@PathVariable Long id) {
        EchantillonDto echantillon = echantillonService.getEchantillonsById(id);
        return ResponseEntity.ok(echantillon);
    }

    @PostMapping
    public ResponseEntity<EchantillonDto> createEchantillon(@RequestBody EchantillonRequestDto echantillonRequestDto) {
        EchantillonDto createdEchantillon = echantillonService.createEchantillon(echantillonRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEchantillon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EchantillonDto> updateEchantillon(
            @PathVariable Long id,
            @RequestBody EchantillonDto echantillonRequestDto
    ) {
        EchantillonDto updatedEchantillon = echantillonService.updateEChantillon(id, echantillonRequestDto);
        return ResponseEntity.ok(updatedEchantillon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEchantillon(@PathVariable Long id) {
        echantillonService.deleteEchantillon(id);
        return ResponseEntity.noContent().build();
    }
}
