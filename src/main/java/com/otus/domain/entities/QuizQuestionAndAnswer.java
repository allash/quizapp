package com.otus.domain.entities;

public class QuizQuestionAndAnswer {
    private Question question;
    private String answer;

    public QuizQuestionAndAnswer(Question question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
