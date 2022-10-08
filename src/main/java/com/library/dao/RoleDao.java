package com.library.dao;

import com.library.model.Role;
import com.library.util.HibernateUtil;
import org.hibernate.Session;

public class RoleDao implements RoleByName {

    @Override
    public Role findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Role role = session.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
        session.close();
        return role;
    }

}
