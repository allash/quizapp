package com.otus.app.student.dto.request;

import javax.validation.constraints.NotBlank;

public class DtoCreateStudentRequest {

    @NotBlank
    public String firstName;

    @NotBlank
    public String lastName;
}
