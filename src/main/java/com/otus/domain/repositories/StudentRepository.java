package com.otus.domain.repositories;

import com.otus.domain.entities.Student;

public interface StudentRepository {
    Student createStudent(String firstName, String lastName);
}
