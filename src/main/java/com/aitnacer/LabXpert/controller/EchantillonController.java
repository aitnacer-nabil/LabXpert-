package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.echantillon.EchantillonRequestDto;
import com.aitnacer.LabXpert.dtos.echantillon.EchantillonDto;
import com.aitnacer.LabXpert.entity.Echantillon;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.service.IEchantillonService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping(Constant.BASE_API_URL +"echantillons")
@AllArgsConstructor
@Slf4j
public class EchantillonController {
    private final IEchantillonService echantillonService;
    private final ModelMapper modelMapper;

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

        log.info("EchantillonRequest{} ",echantillonRequestDto);
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
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id)  {
        Map<String, Object> response = new HashMap<>();
        echantillonService.deleteEchantillon(id);
        response.put("success", true);
        response.put("message", "Echantillon with id: " + id + " has been deleted successfully!");
        return ResponseEntity.ok(response);
    }
}
