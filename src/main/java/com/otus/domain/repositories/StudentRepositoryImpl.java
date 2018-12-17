package com.otus.domain.repositories;

import com.otus.domain.entities.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    public Student createStudent(String firstName, String lastName) {
        return new Student(firstName, lastName);
    }
}
