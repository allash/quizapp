package com.otus.app.student;

import com.otus.app.student.dto.response.DtoStudentResponse;

import java.util.List;

public interface StudentService {
    List<DtoStudentResponse> getAllStudents();
    DtoStudentResponse createStudent(String firstName, String lastName);
}
