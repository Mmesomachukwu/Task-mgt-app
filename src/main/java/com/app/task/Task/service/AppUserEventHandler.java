package com.app.task.Task.service;


import com.app.task.Task.data.model.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;


// only used when using data rest : to intercept the controller method call i.e save
@RepositoryEventHandler
@Component
@Slf4j
public class AppUserEventHandler {

    @Autowired
    AppUserService appUserService;

    @HandleBeforeCreate
    public void handleBeforeCreate(AppUser appUser){

        log.info("AppUser object --> {}", appUser);
        appUserService.encryptPassword(appUser);
    }


}
