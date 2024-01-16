package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.service.impl.UserServiceImpl;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.BASE_API_URL +"user")
@AllArgsConstructor
public class UserController {
    final UserServiceImpl userServiceImpl;
    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getAllAdmin(){
        return ResponseEntity.ok(userServiceImpl.getAllUtilisateur());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getAdminById(@PathVariable(name = "id") Long id) {
        UtilisateurDto utilisateurDto = userServiceImpl.getUtilisateurById(id);
        return ResponseEntity.ok(utilisateurDto);
    }

    @PostMapping
    public ResponseEntity<UtilisateurDto> createUser( @RequestBody UtilisateurDto userDTO) {
        UtilisateurDto utilisateurDto = userServiceImpl.createUtilisateur(userDTO);
        return new ResponseEntity<>(utilisateurDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> updateUser(@PathVariable("id") Long id,  @RequestBody UtilisateurDto userDTO)  {
        return ResponseEntity.ok(userServiceImpl.updateUtilisateur(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id)  {
            userServiceImpl.deleteUtilisateur(id);
        return ResponseEntity.ok("User with id: " + id + " has been deleted successfully!");
    }
}