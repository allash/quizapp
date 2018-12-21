package com.otus.app.quiz.dto.response;

public class DtoQuizResultResponse {
    private String fullName;
    private int correctAnswerCount;
    private int invalidAnswerCount;

    public DtoQuizResultResponse(String fullName, int correctAnswerCount, int invalidAnswerCount) {
        this.fullName = fullName;
        this.correctAnswerCount = correctAnswerCount;
        this.invalidAnswerCount = invalidAnswerCount;
    }

    public int getCorrectAnswerCount() {
        return correctAnswerCount;
    }

    public void setCorrectAnswerCount(int correctAnswerCount) {
        this.correctAnswerCount = correctAnswerCount;
    }

    public int getInvalidAnswerCount() {
        return invalidAnswerCount;
    }

    public void setInvalidAnswerCount(int invalidAnswerCount) {
        this.invalidAnswerCount = invalidAnswerCount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
