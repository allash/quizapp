package com.otus.app.quiz;

import com.otus.app.quiz.dto.response.DtoAnswerResponse;
import com.otus.app.quiz.dto.response.DtoQuestionResponse;
import com.otus.app.quiz.dto.response.DtoQuizResultResponse;
import com.otus.domain.entities.Question;
import com.otus.domain.entities.QuizQuestionAndAnswer;
import com.otus.domain.entities.Student;
import com.otus.domain.repositories.QuestionRepository;
import com.otus.domain.repositories.QuizRepository;
import com.otus.domain.repositories.StudentRepository;
import com.otus.shared.exceptions.question.QuestionNotFoundByIdException;
import com.otus.shared.exceptions.student.StudentNotFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;
    private StudentRepository studentRepository;
    private QuizMapper quizMapper;

    @Autowired
    public QuizServiceImpl(
            QuizRepository quizRepository,
            QuestionRepository questionRepository,
            StudentRepository studentRepository,
            QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.studentRepository = studentRepository;
        this.questionRepository = questionRepository;
        this.quizMapper = quizMapper;
    }

    public void saveAnswer(Integer studentId, Integer questionId, String answer) {

        Student student = studentRepository.getById(studentId);
        if (student == null) throw new StudentNotFoundByIdException(studentId);

        Question question = questionRepository.getQuestionById(questionId);
        if (question == null) throw new QuestionNotFoundByIdException(questionId);
        
        quizRepository.saveAnswer(student.getId(), question, answer);
    }

    public DtoQuizResultResponse calculateResult(Integer studentId) {

        Student student = studentRepository.getById(studentId);
        if (student == null) throw new StudentNotFoundByIdException(studentId);

        List<QuizQuestionAndAnswer> quizQuestionAndAnswers = quizRepository.findAnswers(studentId);

        int correctAnswer = 0;
        int invalidAnswer = 0;

        for (QuizQuestionAndAnswer entry : quizQuestionAndAnswers) {
            if (entry.getQuestion().getAnswer().equals(entry.getAnswer())) correctAnswer++;
            else invalidAnswer++;
        }

        return new DtoQuizResultResponse(student.getFullName(), correctAnswer, invalidAnswer);
    }

    @Override
    public List<DtoQuestionResponse> getQuestions() {
        List<Question> questions = questionRepository.getQuestions();
        return quizMapper.toDtoList(questions);
    }

    @Override
    public List<DtoAnswerResponse> getAnswers(Integer studentId) {
        List<QuizQuestionAndAnswer> quizQuestionAndAnswers = quizRepository.findAnswers(studentId);
        return quizMapper.toDtoAnswerResponseList(quizQuestionAndAnswers);
    }
}
