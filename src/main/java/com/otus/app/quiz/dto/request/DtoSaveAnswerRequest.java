package com.otus.app.quiz.dto.request;

public class DtoSaveAnswerRequest {
    private String answer;

    public DtoSaveAnswerRequest() { }

    public DtoSaveAnswerRequest(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
