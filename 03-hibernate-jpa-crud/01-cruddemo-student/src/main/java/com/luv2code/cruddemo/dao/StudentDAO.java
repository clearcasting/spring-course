package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);
}
