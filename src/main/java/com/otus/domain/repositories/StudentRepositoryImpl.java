package com.otus.domain.repositories;

import com.otus.domain.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    public Student createStudent(String firstName, String lastName) {
        Student created = new Student(firstName, lastName);
        students.add(created);
        return created;
    }
}
