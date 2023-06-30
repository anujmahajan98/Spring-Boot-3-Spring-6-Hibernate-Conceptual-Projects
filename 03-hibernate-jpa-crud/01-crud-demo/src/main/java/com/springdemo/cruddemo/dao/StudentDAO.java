package com.springdemo.cruddemo.dao;

import com.springdemo.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findByID(Integer id);

    List<Student> findAll();

    Integer update(String lastName);

    void delete(Integer id);
}
