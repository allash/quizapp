package com.otus.app.student;

import com.otus.app.student.dto.response.DtoStudentResponse;
import com.otus.domain.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    public DtoStudentResponse toDto(Student student) {
        return new DtoStudentResponse(student.getId(), student.getFirstName(), student.getLastName());
    }

    public List<DtoStudentResponse> toDtoList(List<Student> students) {
        List<DtoStudentResponse> studentsList = new ArrayList<>();
        for (Student student: students) {
            studentsList.add(toDto(student));
        }
        return studentsList;
    }
}
