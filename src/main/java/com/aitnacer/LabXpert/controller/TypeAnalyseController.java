package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.TypeAnalyseDto;
import com.aitnacer.LabXpert.service.ITypeAnalyseService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(Constant.BASE_API_URL +"type-analyse")
@AllArgsConstructor
@Slf4j
public class TypeAnalyseController {
    private final ITypeAnalyseService typeAnalyseService;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('RESPONSABLE','TECHNICIEN')")
    public ResponseEntity<List<TypeAnalyseDto>> getAllTypeAnalyses() {
        List<TypeAnalyseDto> typeAnalyses = typeAnalyseService.getAllTypeAnalyses();
        return ResponseEntity.ok(typeAnalyses);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('RESPONSABLE','TECHNICIEN')")
    public ResponseEntity<TypeAnalyseDto> getTypeAnalyseById(@PathVariable Long id) {
        TypeAnalyseDto typeAnalyse = typeAnalyseService.getTypeAnalyseById(id);
        return ResponseEntity.ok(typeAnalyse);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<TypeAnalyseDto> createTypeAnalyse(@Valid @RequestBody TypeAnalyseDto typeAnalyseDto) {
        TypeAnalyseDto createdTypeAnalyse = typeAnalyseService.createTypeAnalyse(typeAnalyseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTypeAnalyse);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<TypeAnalyseDto> updateTypeAnalyse(
            @PathVariable Long id,
            @Valid @RequestBody TypeAnalyseDto typeAnalyseDto
    ) {
        TypeAnalyseDto updatedTypeAnalyse = typeAnalyseService.updateTypeAnalyse(id, typeAnalyseDto);
        return ResponseEntity.ok(updatedTypeAnalyse);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id)  {
        Map<String, Object> response = new HashMap<>();
        typeAnalyseService.deleteTypeAnalyse(id);
        response.put("success", true);
        response.put("message", "TypeAnalyse with id: " + id + " has been deleted successfully!");
        return ResponseEntity.ok(response);
    }
}
