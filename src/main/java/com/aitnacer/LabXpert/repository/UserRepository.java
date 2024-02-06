package com.aitnacer.LabXpert.repository;


import com.aitnacer.LabXpert.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Utilisateur,Long> {
    List<Utilisateur> findByDeletedFalse();
    Optional<Utilisateur> findByIdAndDeletedFalse(Long id);
    Optional<Utilisateur> findByUserNameAndDeletedFalse(String username);
}
