package com.otus.enums;

public enum MessageKeyEnum {
    ENTER_FIRST_NAME("enter_first_name"),
    ENTER_LAST_NAME("enter_last_name"),
    CORRECT("correct"),
    INVALID("invalid");

    private final String text;

    MessageKeyEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
