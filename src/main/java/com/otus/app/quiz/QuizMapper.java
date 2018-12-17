package com.otus.app.quiz;

import com.otus.app.quiz.dto.response.DtoQuestionResponse;
import com.otus.domain.entities.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuizMapper {

    public DtoQuestionResponse toDto(Question question) {
        return new DtoQuestionResponse(question.getId(), question.getQuestion());
    }

    public List<DtoQuestionResponse> toDtoList(List<Question> questions) {
        List<DtoQuestionResponse> questionDtoList = new ArrayList<>();
        for (Question question: questions) {
            questionDtoList.add(toDto(question));
        }
        return questionDtoList;
    }
}
