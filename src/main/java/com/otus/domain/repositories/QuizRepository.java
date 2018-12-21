package com.otus.domain.repositories;

import com.otus.domain.entities.Question;
import com.otus.domain.entities.QuizQuestionAndAnswer;

import java.util.List;

public interface QuizRepository {

    void saveAnswer(Integer studentId, Question question, String answer);
    List<QuizQuestionAndAnswer> findAnswers(Integer studentId);
    void deleteAll();
}
