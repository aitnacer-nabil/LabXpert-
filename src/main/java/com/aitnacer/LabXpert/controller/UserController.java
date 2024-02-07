package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.echantillon.EchantillonDto;
import com.aitnacer.LabXpert.dtos.echantillon.EchantillonUser;
import com.aitnacer.LabXpert.dtos.UtilisateurDto;
import com.aitnacer.LabXpert.service.IEchantillonService;
import com.aitnacer.LabXpert.service.IUserService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(Constant.BASE_API_URL +"user")
@AllArgsConstructor
@Slf4j
public class UserController {
    final IUserService iUserService;
    final IEchantillonService echantillonService;
    @GetMapping
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<List<UtilisateurDto>> getAllUser(){
        return ResponseEntity.ok(iUserService.getAllUtilisateur());
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<UtilisateurDto> getUSerById(@PathVariable(name = "id") Long id) {
        UtilisateurDto utilisateurDto = iUserService.getUtilisateurById(id);
        return ResponseEntity.ok(utilisateurDto);
    }
    @GetMapping("/{id}/echantillons")
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<EchantillonUser> getEchantillonsByUserId(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(echantillonService.getEchantillonByUserId(id));
    }
    @GetMapping("/{id}/echantillons/{echantillonCode}")
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<EchantillonDto> getEchantillonByUserIdAndCode(@PathVariable(name = "id") Long id, @PathVariable(name = "echantillonCode") String echantillonCode) {

        return ResponseEntity.ok(echantillonService.getEchantillonByUserIdByCode(id,echantillonCode));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<UtilisateurDto> createUser( @RequestBody UtilisateurDto userDTO) {
        UtilisateurDto utilisateurDto = iUserService.createUtilisateur(userDTO);
        return new ResponseEntity<>(utilisateurDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('RESPONSABLE','TECHNICIEN')")
    public ResponseEntity<UtilisateurDto> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UtilisateurDto userDTO)  {
        return ResponseEntity.ok(iUserService.updateUtilisateur(id, userDTO));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id)  {
        Map<String, Object> response = new HashMap<>();
        iUserService.deleteUtilisateur(id);
        response.put("success", true);
        response.put("message", "User with id: " + id + " has been deleted successfully!");
        return ResponseEntity.ok(response);
    }
}
