package com.coderr.cruddemo.dao;

import com.coderr.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);
    public Student findById(int id);
    public List<Student> findAll();
    public List<Student> findByLastName(String theLastName);
    public void update(Student theStudent);
    public void delete(int id);
    public int deleteAll();
}
