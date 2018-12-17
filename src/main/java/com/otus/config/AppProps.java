package com.otus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Locale;

@ConfigurationProperties
@Component
public class AppProps {

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
