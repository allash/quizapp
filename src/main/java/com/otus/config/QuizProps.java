package com.otus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties
public class QuizProps {

    private String languageTag;

    @Value("${server.port}")
    private String serverPort;

    public String getLanguageTag() {
        return languageTag;
    }

    public void setLanguageTag(String languageTag) {
        this.languageTag = languageTag;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public Locale getLocale() {
        return Locale.forLanguageTag(languageTag);
    }

    public String getQuestionsCsvFileNameByPrefix(String prefix) {
        return prefix + "_" + getLocale().getLanguage() + ".csv";
    }
}
