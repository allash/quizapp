package com.otus.unit.services;

import com.otus.BaseSpringTest;
import com.otus.app.quiz.QuizService;
import com.otus.app.quiz.dto.response.DtoQuizResultResponse;
import com.otus.domain.entities.Question;
import com.otus.domain.repositories.QuestionRepository;
import com.otus.domain.repositories.QuizRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class QuizServiceImplTest extends BaseSpringTest {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void saveAnswer() {

        Question question1 = new Question(1, UUID.randomUUID().toString(), UUID.randomUUID().toString());
        String answer1 = UUID.randomUUID().toString();

        Question question2 = new Question(2, UUID.randomUUID().toString(), UUID.randomUUID().toString());
        String answer2 = UUID.randomUUID().toString();

        Question question3 = new Question(3, UUID.randomUUID().toString(), UUID.randomUUID().toString());
        String answer3 = UUID.randomUUID().toString();

        questionRepository.save(Arrays.asList(question1, question2, question3));

        quizService.saveAnswer(question1.getId(), answer1);
        quizService.saveAnswer(question2.getId(), answer2);
        quizService.saveAnswer(question3.getId(), answer3);

        Map<Question, String> answers = quizRepository.findAnswers();
        assertEquals(answers.size(), 3);
    }

    @Test
    public void calculateResult() {

        Question question1 = new Question(1, UUID.randomUUID().toString(), UUID.randomUUID().toString());
        String invalidAnswer = UUID.randomUUID().toString();

        String validAnswer1 = UUID.randomUUID().toString();
        Question question2 = new Question(2, UUID.randomUUID().toString(), validAnswer1);

        String validAnswer2 = UUID.randomUUID().toString();
        Question question3 = new Question(3, UUID.randomUUID().toString(), validAnswer2);

        questionRepository.save(Arrays.asList(question1, question2, question3));

        quizService.saveAnswer(question1.getId(), invalidAnswer);
        quizService.saveAnswer(question2.getId(), validAnswer1);
        quizService.saveAnswer(question3.getId(), validAnswer2);

        DtoQuizResultResponse quizResult = quizService.calculateResult();
        assertEquals(quizResult.getCorrectAnswerCount(), 2);
        assertEquals(quizResult.getInvalidAnswerCount(), 1);
    }
}