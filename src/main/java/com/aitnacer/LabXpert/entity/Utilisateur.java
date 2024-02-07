package com.aitnacer.LabXpert.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "Utilisateur")
@NoArgsConstructor
public class Utilisateur extends UtilisateurInfo implements UserDetails {
    @NotNull(message = "The username should not be null!")
    @Column(name = "username",unique = true)
    private String userName;
    @NotNull(message = "The password should not be null!")
    @NotBlank(message = "The password should not be blank!")
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public Utilisateur(Long id, String nom, String prenom, String Adresse, String telephone, EnumSexe sexe, boolean deleted, String userName, String password, UserRole role) {

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
