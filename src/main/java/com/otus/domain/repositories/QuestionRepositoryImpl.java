package com.otus.domain.repositories;

import com.otus.domain.entities.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private Map<Integer, Question> questions = new HashMap<>();

    public List<Question> getQuestions() {
        return new ArrayList<>(questions.values());
    }

    @Override
    public Question getQuestionById(Integer id) {
        return questions.get(id);
    }

    @Override
    public void save(Question question) {
        questions.put(question.getId(), question);
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