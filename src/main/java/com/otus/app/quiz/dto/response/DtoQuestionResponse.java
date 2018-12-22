package com.otus.app.quiz.dto.response;

public class DtoQuestionResponse {
    private int id;
    private String question;

    public DtoQuestionResponse() { }

    public DtoQuestionResponse(int id, String question) {
        this.id = id;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
