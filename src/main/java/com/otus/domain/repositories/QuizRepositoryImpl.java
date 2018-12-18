package com.otus.domain.repositories;

import com.otus.domain.entities.Question;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class QuizRepositoryImpl implements QuizRepository {

    private Map<Question, String> questions = new HashMap();

    public void saveAnswer(Question question, String answer) {
        questions.put(question, answer);
    }

    public Map<Question, String> findAnswers() {
        return questions;
    }

    @Override
    public void deleteAll() {
        questions.clear();
    }
}
