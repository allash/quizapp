package com.otus.domain.repositories;

import com.otus.domain.entities.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question getQuestionById(Integer id) {
        for (Question question : questions) if (question.getId().equals(id)) return question;
        return null;
    }

    @Override
    public void save(Question question) {
        questions.add(question);
    }

    @Override
    public void save(List<Question> questions) {
        for (Question question : questions) {
            save(question);
        }
    }

    @Override
    public void deleteAll() {
        questions.clear();
    }
}