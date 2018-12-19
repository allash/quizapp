package com.otus.integration;

import com.otus.BaseSpringTest;
import com.otus.app.student.dto.request.DtoCreateStudentRequest;
import com.otus.domain.entities.Student;
import com.otus.domain.repositories.StudentRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.List;
import java.util.UUID;

public class StudentControllerTest extends BaseSpringTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void canCreateNewStudent() {

        studentRepository.clear();
        List<Student> studentsBefore = studentRepository.findAll();
        Assertions.assertEquals(studentsBefore.size(), 0);

        DtoCreateStudentRequest createStudentRequest = new DtoCreateStudentRequest();
        createStudentRequest.setFirstName(UUID.randomUUID().toString());
        createStudentRequest.setLastName(UUID.randomUUID().toString());
        HttpEntity httpEntity = new HttpEntity(createStudentRequest, new HttpHeaders());

        restTemplate.exchange(createURLWithPort("/api/students"), HttpMethod.POST, httpEntity, Object.class);

        List<Student> studentsAfter = studentRepository.findAll();
        Assertions.assertEquals(studentsAfter.size(), 1);

        Student createdStudent = studentsAfter.get(0);
        Assertions.assertEquals(createStudentRequest.getFirstName(), createdStudent.getFirstName());
        Assertions.assertEquals(createStudentRequest.getLastName(), createdStudent.getLastName());
    }
}
