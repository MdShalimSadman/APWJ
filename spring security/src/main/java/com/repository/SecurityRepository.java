package com.repository;

import com.domain.LeaveApplication;
import com.domain.Security;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SecurityRepository {

    private final SessionFactory sessionFactory;

    public SecurityRepository(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public  boolean create(Security security) {
        Session session = sessionFactory.getCurrentSession();
        session.save(security);

        return true;
    }

    public Security findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Security s where s.username = :s";

        Security result = session.createQuery(hql,Security.class)
                .setParameter("s", username).getSingleResult()
                ;
        return result;
    }
}
