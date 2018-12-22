package com.otus.app.student;

import com.otus.app.student.dto.response.DtoStudentResponse;
import com.otus.domain.entities.Student;
import com.otus.domain.repositories.StudentRepository;
import com.otus.shared.exceptions.student.StudentNotFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<DtoStudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDtoList(students);
    }

    @Override
    public DtoStudentResponse getStudentById(int id) {
        Student student = studentRepository.getById(id);
        if (student == null) throw new StudentNotFoundByIdException(id);
        return studentMapper.toDto(student);
    }

    public DtoStudentResponse createStudent(String firstName, String lastName) {
        Student student = studentRepository.save(firstName, lastName);
        return studentMapper.toDto(student);
    }
}
