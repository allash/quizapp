package com.otus.shared.services;

import com.otus.config.QuizProps;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class i18nServiceImpl implements i18nService {

    private MessageSource messageSource;
    private QuizProps appProps;

    public i18nServiceImpl(MessageSource messageSource, QuizProps appProps) {
        this.messageSource = messageSource;
        this.appProps = appProps;
    }

    public String getMessage(String messageId) {
        return messageSource.getMessage(messageId, null, appProps.getLocale()).trim();
    }
}
