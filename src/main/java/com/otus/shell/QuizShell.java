package com.otus.shell;

import com.otus.app.quiz.dto.request.DtoSaveAnswerRequest;
import com.otus.app.quiz.dto.response.DtoQuestionResponse;
import com.otus.app.quiz.dto.response.DtoQuizResultResponse;
import com.otus.app.student.dto.request.DtoCreateStudentRequest;
import com.otus.app.student.dto.response.DtoStudentResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class QuizShell extends BaseShell {

    @ShellMethod("Get students")
    public String students() {

        ResponseEntity<List<DtoStudentResponse>> result = restTemplate.exchange(
                        createURLWithPort("/api/students"),
                        HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<DtoStudentResponse>>() {
                        }
        );

        List<String> students = new ArrayList<>();
        for (DtoStudentResponse dto : result.getBody()) {
            students.add(buildStudentInfo(dto));
        }

        return String.join("\n", students);
    }

    @ShellMethod("Get student by id")
    public String student(@ShellOption int id) {

        ResponseEntity<DtoStudentResponse> result = restTemplate.exchange(
                createURLWithPort("/api/students/" + id),
                HttpMethod.GET,
                null,
                DtoStudentResponse.class);

        return buildStudentInfo(result.getBody());
    }

    @ShellMethod(value = "Create student", key = "create")
    public String createStudent(@ShellOption String firstName, @ShellOption String lastName) {

        HttpEntity httpEntity = new HttpEntity(new DtoCreateStudentRequest(firstName, lastName), new HttpHeaders());
        ResponseEntity<DtoStudentResponse> result = restTemplate.exchange(
                createURLWithPort("/api/students"),
                HttpMethod.POST,
                httpEntity,
                DtoStudentResponse.class
        );

        return buildStudentInfo(result.getBody());
    }

    @ShellMethod("Get questions")
    public String questions() {

        ResponseEntity<List<DtoQuestionResponse>> result = restTemplate.exchange(
                createURLWithPort("/api/quiz/questions"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DtoQuestionResponse>>() {}
        );

        List<String> questions = new ArrayList<>();
        for (DtoQuestionResponse dto: result.getBody()) {
            questions.add(buildQuestionInfo(dto));
        }

        return String.join("\n", questions);
    }

    @ShellMethod(value = "Save answer", key = "answer")
    public String saveAnswer(@ShellOption int studentId, @ShellOption int questionId, @ShellOption String answer) {

        HttpEntity httpEntity = new HttpEntity(new DtoSaveAnswerRequest(answer), new HttpHeaders());
        restTemplate.exchange(
                createURLWithPort("/api/quiz/" + studentId + "/questions/" + questionId),
                HttpMethod.POST,
                httpEntity,
                Object.class
        );

        return "Answer saved";
    }

    @ShellMethod(value = "Calculate result", key = "calculate")
    public String calculateResult(@ShellOption int studentId) {

        ResponseEntity<DtoQuizResultResponse> result = restTemplate.exchange(
                createURLWithPort("/api/quiz/" + studentId + "/calculate"),
                HttpMethod.POST,
                null,
                DtoQuizResultResponse.class
        );

        return buildQuizResultInfo(result.getBody());
    }

    private String buildStudentInfo(DtoStudentResponse dto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dto.getId())
                .append(" - ")
                .append(dto.getFirstName())
                .append(" ")
                .append(dto.getLastName());
        return stringBuilder.toString();
    }

    private String buildQuestionInfo(DtoQuestionResponse dto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(dto.getId())
                .append(" - ")
                .append(dto.getQuestion());
        return stringBuilder.toString();
    }

    private String buildQuizResultInfo(DtoQuizResultResponse dto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(dto.getFullName())
                .append("\n")
                .append("Correct: " + dto.getCorrectAnswerCount())
                .append("\n")
                .append("Incorrect: " + dto.getInvalidAnswerCount());
        return stringBuilder.toString();
    }
}
