package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.echantillon.EchantillonDto;
import com.aitnacer.LabXpert.dtos.echantillon.EchantillonUser;
import com.aitnacer.LabXpert.dtos.echantillon.EchantillonView;
import com.aitnacer.LabXpert.dtos.UtilisateurDto;
import com.aitnacer.LabXpert.service.IEchantillonService;
import com.aitnacer.LabXpert.service.impl.UserServiceImpl;
import com.aitnacer.LabXpert.utils.Constant;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constant.BASE_API_URL +"user")
@AllArgsConstructor
@Slf4j
public class UserController {
    final UserServiceImpl userServiceImpl;
    final IEchantillonService echantillonService;
    @GetMapping
    @JsonView(EchantillonView.FullResponse.class)
    public ResponseEntity<List<UtilisateurDto>> getAllUser(){
        return ResponseEntity.ok(userServiceImpl.getAllUtilisateur());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getUSerById(@PathVariable(name = "id") Long id) {
        UtilisateurDto utilisateurDto = userServiceImpl.getUtilisateurById(id);
        return ResponseEntity.ok(utilisateurDto);
    }
    @GetMapping("/{id}/echantillons")
    public ResponseEntity<EchantillonUser> getEchantillonsByUserId(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(echantillonService.getEchantillonByUserId(id));
    }
    @GetMapping("/{id}/echantillons/{echantillonCode}")
    public ResponseEntity<EchantillonDto> getEchantillonByUserIdAndCode(@PathVariable(name = "id") Long id, @PathVariable(name = "echantillonCode") String echantillonCode) {

        return ResponseEntity.ok(echantillonService.getEchantillonByUserIdByCode(id,echantillonCode));
    }

    @PostMapping
    public ResponseEntity<UtilisateurDto> createUser( @RequestBody UtilisateurDto userDTO) {
        UtilisateurDto utilisateurDto = userServiceImpl.createUtilisateur(userDTO);
        return new ResponseEntity<>(utilisateurDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UtilisateurDto userDTO)  {
        return ResponseEntity.ok(userServiceImpl.updateUtilisateur(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id)  {
            userServiceImpl.deleteUtilisateur(id);
        return ResponseEntity.ok("User with id: " + id + " has been deleted successfully!");
    }
}
