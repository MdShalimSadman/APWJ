package com.repository;

import com.domain.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class EmployeeRepository {

    private SessionFactory sessionFactory;

    public EmployeeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Employee> list() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> studentQuery = session.createQuery("from Student", Employee.class);
        return studentQuery.getResultList();
    }

    public boolean create(Employee student) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        return true;
    }

    public Employee get(Long id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    /*public boolean update(Student student) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, student.getFirstname());
        preparedStatement.setString(2, student.getLastname());
        preparedStatement.setLong(3, student.getId());
        return preparedStatement.execute();
    }

    public boolean delete(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setLong(1, id);
        return preparedStatement.execute();
    }

    private List<Student> mapper(ResultSet resultSet) throws SQLException {
        List<Student> students = new ArrayList<>();
        while(resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getLong(1));
            student.setFirstname(resultSet.getString(2));
            student.setLastname(resultSet.getString(3));
            students.add(student);
        }
        return students;
    }*/
}
