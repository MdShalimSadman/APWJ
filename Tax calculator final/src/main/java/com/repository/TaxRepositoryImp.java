package com.repository;

import com.domain.Tax;
import com.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.sql.SQLException;

@Repository
public class TaxRepositoryImp implements TaxRepository{

    private final SessionFactory sessionFactory;

    public TaxRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void insert(Tax tax) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(tax);
    }

    @Override
    public Tax get(String email) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tax.class, email);

    }


}