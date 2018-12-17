package com.otus.domain.repositories;

import com.otus.domain.entities.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudents();
    Student createStudent(String firstName, String lastName);
}
