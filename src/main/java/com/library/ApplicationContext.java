package com.library;

import com.library.dto.ActiveUser;
import com.library.service.UserService;
import com.library.service.LoginServiceImpl;

public class ApplicationContext {

   private final UserService loggedIn = new LoginServiceImpl();

    public static ActiveUser activeUser(){
        return null;
    }
    public void setActiveUser(){

    }
}
