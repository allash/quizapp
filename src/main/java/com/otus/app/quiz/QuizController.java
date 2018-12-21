package com.otus.app.quiz;

import com.otus.app.quiz.dto.request.DtoSaveAnswerRequest;
import com.otus.app.quiz.dto.response.DtoAnswerResponse;
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

    @PostMapping("/{studentId}/questions/{questionId}")
    public void saveAnswer(@PathVariable Integer studentId,
                           @PathVariable Integer questionId,
                           @Valid @RequestBody DtoSaveAnswerRequest dto) {
        quizService.saveAnswer(studentId, questionId, dto.getAnswer());
    }

    @PostMapping("/{studentId}/calculate")
    public DtoQuizResultResponse calculateResult(@PathVariable Integer studentId) {
        return quizService.calculateResult(studentId);
    }

    @GetMapping("/questions")
    public List<DtoQuestionResponse> getQuestions() {
        return quizService.getQuestions();
    }

    @GetMapping("/{studentId}/answers")
    public List<DtoAnswerResponse> getAnswers(@PathVariable Integer studentId) { return quizService.getAnswers(studentId); }
}
