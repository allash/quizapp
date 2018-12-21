package com.otus.domain.repositories;

import com.otus.domain.entities.Student;
import com.otus.shared.helpers.RandomGeneratorHelper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private Map<Integer, Student> students = new HashMap<>();

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Student save(Integer id, String firstName, String lastName) {
        Student created = new Student(id, firstName, lastName);
        students.put(id, created);
        return created;
    }

    public Student save(String firstName, String lastName) {
        return save(RandomGeneratorHelper.generateId(), firstName, lastName);
    }

    @Override
    public Student getById(Integer id) {
        return students.get(id);
    }

    @Override
    public void clear() {
        students.clear();
    }
}
