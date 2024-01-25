package com.lucasbonato.todosimple.exceptions;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final Integer STATUS;
    private final String MESSAGE;
    private String stackTrace;
    private List<ValidationError> errors;

    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class ValidationError {
        private final String FIELD;
        private final String MESSAGE;
    }

    public void addValidationError(String field, String message) {
        if(Objects.isNull(errors))
            errors = new ArrayList<>();
        errors.add(new ValidationError(field, message));
    }

}