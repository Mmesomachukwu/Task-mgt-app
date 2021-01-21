package com.app.task.Task.service;


import com.app.task.Task.data.model.AppUser;
import com.app.task.Task.data.model.Roles;
import com.app.task.Task.data.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(appUser.getUsername(), appUser.getPassword(), getAuthorities(appUser.getRoles()));
    }


    public Collection<? extends GrantedAuthority> getAuthorities(List<Roles> authorities) {
        return getGrantedAuthority(authorities);
    }

    // SimpleGrantedAuthority:let you pass a string and convert it to granted authority

    private List<GrantedAuthority> getGrantedAuthority(List<Roles> roles){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for(Roles role: roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(String.valueOf(role)));
        }
        return grantedAuthorities;
    }

}