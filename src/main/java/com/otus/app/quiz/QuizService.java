package com.otus.app.quiz;


import com.otus.app.quiz.dto.response.DtoAnswerResponse;
import com.otus.app.quiz.dto.response.DtoQuestionResponse;
import com.otus.app.quiz.dto.response.DtoQuizResultResponse;

import java.util.List;

public interface QuizService {

    void saveAnswer(Integer studentId, Integer questionId, String answer);

    DtoQuizResultResponse calculateResult(Integer studentId);

    List<DtoQuestionResponse> getQuestions();

    List<DtoAnswerResponse> getAnswers(Integer studentId);
}