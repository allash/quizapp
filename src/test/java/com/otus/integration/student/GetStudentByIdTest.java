package com.otus.integration.student;

import com.otus.BaseSpringTest;
import com.otus.app.student.dto.response.DtoStudentResponse;
import com.otus.domain.entities.Student;
import com.otus.domain.repositories.StudentRepository;
import com.otus.shared.helpers.RandomGeneratorHelper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

public class GetStudentByIdTest extends BaseSpringTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void canGetStudentById() {

        studentRepository.clear();

        Student student = fixtures.createStudent();
        DtoStudentResponse dto = restTemplate.exchange(createURLWithPort("/api/students/" + student.getId()),
                HttpMethod.GET,
                null,
                DtoStudentResponse.class)
                .getBody();

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(dto.getId(), student.getId());
        Assertions.assertEquals(dto.getFirstName(), student.getFirstName());
        Assertions.assertEquals(dto.getLastName(), student.getLastName());
    }

    @Test
    public void cannotGetStudentWithInvalidId() {
        studentRepository.clear();

        fixtures.createStudent();
        HttpStatus httpStatus = restTemplate.exchange(createURLWithPort("/api/students/" + RandomGeneratorHelper.generateId()),
                HttpMethod.GET,
                null,
                DtoStudentResponse.class).getStatusCode();
        Assertions.assertEquals(HttpStatus.NOT_FOUND, httpStatus);
    }
}
