package com.otus.domain.repositories;

import com.otus.domain.entities.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student save(String firstName, String lastName);
    Student save(Integer id, String firstName, String lastName);
    Student getById(Integer id);
    void clear();
}
