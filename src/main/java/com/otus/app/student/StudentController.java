package com.otus.app.student;

import com.otus.app.student.dto.request.DtoCreateStudentRequest;
import com.otus.app.student.dto.response.DtoStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<DtoStudentResponse> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DtoStudentResponse createStudent(@Valid @RequestBody DtoCreateStudentRequest student) {
        return studentService.createStudent(student.getFirstName(), student.getLastName());
    }
}
