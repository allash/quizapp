package com.otus.app.quiz.dto.response;

public class DtoAnswerResponse {
    private Integer questionId;
    private String question;
    private String studentAnswer;

    public DtoAnswerResponse(Integer questionId, String question, String studentAnswer) {
        this.questionId = questionId;
        this.question = question;
        this.studentAnswer = studentAnswer;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }
}
