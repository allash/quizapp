package com.otus;

import com.otus.config.QuizProps;
import com.otus.domain.entities.Question;
import com.otus.domain.helpers.CsvHelper;
import com.otus.domain.repositories.QuestionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(QuizProps.class)
public class QuizApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QuizApplication.class, args);
		QuizProps quizProps = context.getBean(QuizProps.class);
		CsvHelper csvHelper = context.getBean(CsvHelper.class);
		QuestionRepository questionRepository = context.getBean(QuestionRepository.class);
		List<Question> questions = csvHelper.readCsv(Question.class, quizProps.getQuestionsCsvFileNameByPrefix("quiz"));
		questionRepository.save(questions);
	}
}

