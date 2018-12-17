package com.otus.app.quiz;


import com.otus.app.quiz.dto.response.DtoQuestionResponse;
import com.otus.app.quiz.dto.response.DtoQuizResultResponse;

import java.util.List;

public interface QuizService {

    void saveAnswer(Integer questionId, String answer);

    DtoQuizResultResponse calculateResult();

    List<DtoQuestionResponse> getQuestions();
}