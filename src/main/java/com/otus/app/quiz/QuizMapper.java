package com.otus.app.quiz;

import com.otus.app.quiz.dto.response.DtoAnswerResponse;
import com.otus.app.quiz.dto.response.DtoQuestionResponse;
import com.otus.domain.entities.Question;
import com.otus.domain.entities.QuizQuestionAndAnswer;
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

    public DtoAnswerResponse toDtoAnswerResponse(QuizQuestionAndAnswer entity) {
        return new DtoAnswerResponse(entity.getQuestion().getId(), entity.getQuestion().getQuestion(), entity.getAnswer());
    }

    public List<DtoAnswerResponse> toDtoAnswerResponseList(List<QuizQuestionAndAnswer> questions) {
        List<DtoAnswerResponse> questionDtoList = new ArrayList<>();
        for (QuizQuestionAndAnswer question: questions) {
            questionDtoList.add(toDtoAnswerResponse(question));
        }
        return questionDtoList;
    }
}
