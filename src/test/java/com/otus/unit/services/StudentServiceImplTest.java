package com.otus.unit.services;

import com.otus.BaseSpringTest;
import com.otus.app.student.StudentService;
import com.otus.app.student.dto.response.DtoStudentResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceImplTest extends BaseSpringTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void createStudent() {
        String firstName = UUID.randomUUID().toString();
        String lastName = UUID.randomUUID().toString();

        DtoStudentResponse student = studentService.createStudent(firstName, lastName);

        assertEquals(student.getFirstName(), firstName);
        assertEquals(student.getLastName(), lastName);
    }
}