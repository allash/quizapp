package com.otus.domain.repositories;

import com.otus.domain.entities.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getQuestions();
    Question getQuestionById(Integer id);
    void save(Question question);
    void save(List<Question> questions);
    void deleteAll();
}
