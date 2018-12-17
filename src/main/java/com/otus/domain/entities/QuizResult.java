package com.otus.domain.entities;

public class QuizResult {
    private int correctAnswerCount;
    private int invalidAnswerCount;

    public QuizResult(int correctAnswerCount, int invalidAnswerCount) {
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
