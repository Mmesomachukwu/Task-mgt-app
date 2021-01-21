package com.app.task.Task.service;

import com.app.task.Task.data.model.AppUser;
import com.app.task.Task.data.model.Roles;
import com.app.task.Task.data.repository.AppUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    BCryptPasswordEncoder bCryptPasswordEncoder;

    AppUserRepository appUserRepository;

    public AppUserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, AppUserRepository appUserRepository){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.appUserRepository = appUserRepository;
    }

    // we need to create an event class to intercept the method to save that has been implemented by spring since we used data rest

    // encrypt password and set roles
    @Override
    public void registerUser(AppUser appUser) {
        appUser.setRoles(List.of(Roles.ROLE_USER));
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));

    }
}
