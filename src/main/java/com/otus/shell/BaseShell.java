package com.otus.shell;

import com.otus.config.QuizProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


public class BaseShell {

    @Autowired
    private QuizProps quizProps;
    protected RestTemplate restTemplate;

    public BaseShell() {
        restTemplate = new RestTemplate();
    }

    protected String createURLWithPort(String uri) {
        System.out.println(quizProps.getServerPort());
        return "http://localhost:" + quizProps.getServerPort() + uri;
    }
}
