package com.otus.config;

import com.otus.domain.entities.Question;
import com.otus.domain.repositories.QuestionRepository;
import com.otus.domain.repositories.StudentRepository;
import com.otus.shared.services.CsvService;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.List;

@Configuration
public class AppConfig {

    private final static String FILE_NAME = "quiz";

    public AppConfig(
            QuestionRepository questionRepository,
            StudentRepository studentRepository,
            QuizProps quizProps,
            CsvService csvService
    ) {
        List<Question> questions = csvService.readCsv(
                Question.class,
                quizProps.getQuestionsCsvFileNameByPrefix(FILE_NAME));
        questionRepository.save(questions);

        // fixtures for testing
        studentRepository.save(1, "John", "Doe");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
