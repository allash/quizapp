package com.otus.domain.repositories;

import com.otus.domain.entities.Question;

import java.util.Map;

public interface QuizRepository {

    void saveAnswer(Question question, String answer);
    Map<Question, String> findAnswers();
}
