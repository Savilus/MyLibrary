package com.library;

import com.library.model.Address;
import com.library.model.Role;
import com.library.model.User;
import com.library.service.LoginService;
import com.library.service.LoginServiceImpl;
import com.library.util.HibernateUtil;
import org.hibernate.Session;

public class ApplicationContext {

   private final LoginService loggedIn = new LoginServiceImpl();

    public static void showLoggedUser(){

        // SELECT * FROM user AS u
        //JOIN role AS r ON r.id = u.id
        //JOIN address  AS a ON a.id = u.id;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.createQuery("SELECT * FROM User ", User.class);
        session.createQuery("SELECT name FROM Role ", Role.class);
        session.createQuery("SELECT * FROM address", Address.class);



        session.close();
    }
}
