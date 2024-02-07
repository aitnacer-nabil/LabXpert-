package com.aitnacer.LabXpert.security;

import com.aitnacer.LabXpert.entity.Utilisateur;
import com.aitnacer.LabXpert.service.IUserService;
import com.aitnacer.LabXpert.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    private IUserService userService;

    public UserDetailServiceImpl(IUserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("UserName Login {}",username);
        Utilisateur  utilisateur= userService.loadUserByEmail(username);
        if(utilisateur == null) throw new UsernameNotFoundException("User not found");
        GrantedAuthority authority = new SimpleGrantedAuthority(utilisateur.getRole().name());

        log.info("utilisateur Login {}",utilisateur);
        User user =  new User(utilisateur.getUsername(),utilisateur.getPassword(), Collections.singleton(authority));
        log.info("User Login {}",user);
        return user;
    }

}
