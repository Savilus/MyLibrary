package com.library;

import com.library.dto.ActiveUser;
import com.library.service.LoginService;
import com.library.service.LoginServiceImpl;

public class ApplicationContext {

   private final LoginService loggedIn = new LoginServiceImpl();

    public static ActiveUser activeUser(){
        return null;
    }
    public void setActiveUser(){

    }
}
