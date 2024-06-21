package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// repository annotation supports component scanning
// translates JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;


    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student
        Student student = entityManager.find(Student.class, id);
        // delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:data", Student.class);

        query.setParameter("data", lastName);


        return query.getResultList();
    }
}
