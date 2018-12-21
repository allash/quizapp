package com.otus.domain.repositories;

import com.otus.domain.entities.Question;
import com.otus.domain.entities.QuizQuestionAndAnswer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuizRepositoryImpl implements QuizRepository {

    private Map<Integer, List<QuizQuestionAndAnswer>> questions = new HashMap();

    public void saveAnswer(Integer studentId, Question question, String answer) {

        if (!isQuestionAlreadyExists(studentId, question.getId())) {
            QuizQuestionAndAnswer entity = new QuizQuestionAndAnswer(question, answer);
            List<QuizQuestionAndAnswer> questionAndAnswers = questions.getOrDefault(studentId, new ArrayList<>());
            questionAndAnswers.add(entity);
            questions.put(studentId, questionAndAnswers);
        }
    }

    private boolean isQuestionAlreadyExists(Integer studentId, Integer questionId) {
        for (QuizQuestionAndAnswer quizQuestionAndAnswer : questions.getOrDefault(studentId, new ArrayList<>())) {
            if (quizQuestionAndAnswer.getQuestion().getId().equals(questionId)) {
                return true;
            }
        }

        return false;
    }

    public List<QuizQuestionAndAnswer> findAnswers(Integer studentId) {
        return questions.get(studentId);
    }

    @Override
    public void deleteAll() {
        questions.clear();
    }
}
