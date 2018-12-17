package com.otus.domain.repositories;

import com.otus.domain.entities.Question;
import com.otus.domain.helpers.CsvHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private CsvHelper csvHelper;

    @Autowired
    public QuestionRepositoryImpl(CsvHelper csvHelper) {
        this.csvHelper = csvHelper;
    }

    public List<Question> getQuestions(String fileName) {
        return csvHelper.readCsv(Question.class, fileName);
    }

    @Override
    public Question getQuestionById(Integer id, String fileName) {
        List<Question> questions = csvHelper.readCsv(Question.class, fileName);
        for (Question question : questions) if (question.getId().equals(id)) return question;
        return null;
    }
}