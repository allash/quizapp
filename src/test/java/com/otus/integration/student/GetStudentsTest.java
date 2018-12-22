package com.otus.integration.student;

import com.otus.BaseSpringTest;
import com.otus.app.student.dto.response.DtoStudentResponse;
import com.otus.domain.entities.Student;
import com.otus.domain.repositories.StudentRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.Arrays;
import java.util.List;

public class GetStudentsTest extends BaseSpringTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void canGetStudents() {

        studentRepository.clear();

        List<Student> students = Arrays.asList(
                fixtures.createStudent(),
                fixtures.createStudent(),
                fixtures.createStudent(),
                fixtures.createStudent()
        );

        List<DtoStudentResponse> dtoList = restTemplate.exchange(createURLWithPort("/api/students"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DtoStudentResponse>>() {})
                .getBody();

        Assertions.assertEquals(students.size(), dtoList.size());
    }
}
