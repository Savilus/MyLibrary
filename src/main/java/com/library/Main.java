package com.library;

import com.library.util.HibernateUtil;
import com.library.view.LoginView;
import com.library.view.MainMenuView;
import com.mysql.cj.log.Log;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {


        new LoginView().display();
    }
}

