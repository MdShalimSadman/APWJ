package com.repository;

import com.domain.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

@Repository
public class AdminRepositoryImp implements AdminRepository{

    private final SessionFactory sessionFactory;

    public AdminRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void insert(Admin admin) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(admin);
    }

    @Override
    public Admin getAdmin(Admin admin) {
        return null;
    }

    public Admin getUser(Admin admin) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            Query<Admin> query = session.createQuery("from adminTable where username = username and password = password", Admin.class);
            query.setParameter("username", admin.getUsername());
            query.setParameter("password", admin.getPassword());

            admin = query.getSingleResult();
            return admin;
        }catch (NoResultException e) {
            // TODO: handle exception
            return null;
        }
    }



    @Override
    public void update(Admin admin) {

    }


    public Admin get(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Admin.class, username);
    }


}