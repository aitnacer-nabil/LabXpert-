package com.aitnacer.LabXpert.security;

import com.aitnacer.LabXpert.entity.Utilisateur;
import com.aitnacer.LabXpert.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private UserServiceImpl userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Utilisateur  utilisateur= userService.loadUserByEmail(userName);
        if(utilisateur == null) throw new UsernameNotFoundException("User not found");
        GrantedAuthority authority = new SimpleGrantedAuthority(utilisateur.getRole().name());
        return new User(utilisateur.getUsername(),utilisateur.getPassword(), Collections.singleton(authority));
    }
}
