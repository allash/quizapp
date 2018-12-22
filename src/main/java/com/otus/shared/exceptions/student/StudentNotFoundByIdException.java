package com.otus.shared.exceptions.student;

import com.otus.shared.exceptions.EntityNotFoundException;

public class StudentNotFoundByIdException extends EntityNotFoundException {
    public StudentNotFoundByIdException(Integer id) {
        super(id.toString());
    }
}
