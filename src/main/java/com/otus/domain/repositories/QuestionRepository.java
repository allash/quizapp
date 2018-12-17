package com.otus.domain.repositories;

import com.otus.domain.entities.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getQuestions(String fileName);
    Question getQuestionById(Integer id, String fileName);
}
