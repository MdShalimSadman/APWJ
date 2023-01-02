package com.repository;

import com.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

@Repository
public class AccountRepositoryImp implements AccountRepository{

    private final SessionFactory sessionFactory;

    public AccountRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void insert(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User getUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            Query<User> query = session.createQuery("from taxreg where username =: username and password =: password", User.class);
            query.setParameter("username", user.getUsername());
            query.setParameter("password", user.getPassword());

            user = query.getSingleResult();
            return user;
        }catch (NoResultException e) {
            // TODO: handle exception
            return null;
        }
    }



    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }


    public User get(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, username);
    }


}