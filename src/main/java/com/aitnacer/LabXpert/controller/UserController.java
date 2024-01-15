package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.UtilisateurDto;
import com.aitnacer.LabXpert.service.UserService;
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
    final UserService userService;
    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getAllAdmin(){
        return ResponseEntity.ok(userService.getAllAdministrateurs());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getAdminById(@PathVariable(name = "id") Long id) {
        UtilisateurDto utilisateurDto = userService.getAdministrateurById(id);
        return ResponseEntity.ok(utilisateurDto);
    }

    @PostMapping
    public ResponseEntity<UtilisateurDto> createUser( @RequestBody UtilisateurDto userDTO) {
        UtilisateurDto utilisateurDto = userService.createAdministrateur(userDTO);
        return new ResponseEntity<>(utilisateurDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> updateUser(@PathVariable("id") Long id,  @RequestBody UtilisateurDto userDTO)  {
        return ResponseEntity.ok(userService.updateAdministrateur(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id)  {
            userService.deleteAdministrateur(id);
        return ResponseEntity.ok("User with id: " + id + " has been deleted successfully!");
    }
}
