package com.otus.app.quiz;

import com.otus.app.quiz.dto.request.DtoSaveAnswerRequest;
import com.otus.app.quiz.dto.response.DtoQuestionResponse;
import com.otus.app.quiz.dto.response.DtoQuizResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

    // TODO: Student will be retrieved from session context in future

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/questions/{questionId}/answer")
    public void saveAnswer(@PathVariable Integer questionId, @Valid @RequestBody DtoSaveAnswerRequest dto) {
        quizService.saveAnswer(questionId, dto.getAnswer());
    }

    @PostMapping("/calculate")
    public DtoQuizResultResponse calculateResult() {
        return quizService.calculateResult();
    }

    @GetMapping("/questions")
    public List<DtoQuestionResponse> getQuestions() {
        return quizService.getQuestions();
    }
}
