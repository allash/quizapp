package com.otus.shared.exceptions.question;

import com.otus.shared.exceptions.EntityNotFoundException;

public class QuestionNotFoundByIdException extends EntityNotFoundException {
    public QuestionNotFoundByIdException(Integer id) {
        super(id.toString());
    }
}
