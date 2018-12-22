package com.otus.config;

import com.otus.domain.entities.Student;
import com.otus.domain.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FixtureGenerator {

    private StudentRepository studentRepository;

    @Autowired
    public FixtureGenerator(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent() {
        return createStudent(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

    public Student createStudent(String firstName, String lastName) {
        return studentRepository.save(firstName, lastName);
    }
}
