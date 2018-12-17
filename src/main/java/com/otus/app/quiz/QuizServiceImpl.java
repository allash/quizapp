package com.otus.app.quiz;

import com.otus.app.quiz.dto.response.DtoQuestionResponse;
import com.otus.config.AppProps;
import com.otus.domain.entities.Question;
import com.otus.app.quiz.dto.response.DtoQuizResultResponse;
import com.otus.domain.repositories.QuizRepository;
import com.otus.domain.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;
    private AppProps appProps;
    private QuizMapper quizMapper;

    private static final String FILE_NAME = "quiz";

    @Autowired
    public QuizServiceImpl(
            QuizRepository quizRepository,
            QuestionRepository questionRepository,
            AppProps appProps,
            QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.appProps = appProps;
        this.quizMapper = quizMapper;
    }

    public void saveAnswer(Integer questionId, String answer) {
        Question question = questionRepository.getQuestionById(questionId, appProps.getQuestionsCsvFileNameByPrefix(FILE_NAME));
        quizRepository.saveAnswer(question, answer);
    }

    public DtoQuizResultResponse calculateResult() {

        Map<Question, String> answers = quizRepository.findAnswers();

        int correctAnswer = 0;
        int invalidAnswer = 0;

        for (Map.Entry<Question, String> entry : answers.entrySet()) {
            if (entry.getKey().getAnswer().equals(entry.getValue())) correctAnswer++;
            else invalidAnswer++;
        }

        return new DtoQuizResultResponse(correctAnswer, invalidAnswer);
    }

    @Override
    public List<DtoQuestionResponse> getQuestions() {
        List<Question> questions = questionRepository.getQuestions(appProps.getQuestionsCsvFileNameByPrefix(FILE_NAME));
        return quizMapper.toDtoList(questions);
    }
}
