package com.otus.app.quiz.dto.response;

public class DtoQuizResultResponse {
    private int correctAnswerCount;
    private int invalidAnswerCount;

    public DtoQuizResultResponse(int correctAnswerCount, int invalidAnswerCount) {
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
}
