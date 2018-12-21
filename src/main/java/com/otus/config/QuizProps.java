package com.otus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties
public class QuizProps {

    private String languageTag;

    public String getLanguageTag() {
        return languageTag;
    }

    public void setLanguageTag(String languageTag) {
        this.languageTag = languageTag;
    }

    public Locale getLocale() {
        return Locale.forLanguageTag(languageTag);
    }

    public String getQuestionsCsvFileNameByPrefix(String prefix) {
        return prefix + "_" + getLocale().getLanguage() + ".csv";
    }
}
