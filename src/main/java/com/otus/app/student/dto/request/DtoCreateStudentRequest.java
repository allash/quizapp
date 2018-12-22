package com.otus.app.student.dto.request;

import javax.validation.constraints.NotBlank;

public class DtoCreateStudentRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public DtoCreateStudentRequest() { }

    public DtoCreateStudentRequest(@NotBlank String firstName, @NotBlank String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
