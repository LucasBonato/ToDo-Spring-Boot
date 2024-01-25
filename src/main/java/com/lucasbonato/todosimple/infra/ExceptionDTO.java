package com.lucasbonato.todosimple.infra;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ExceptionDTO {
    String message;

    ExceptionDTO(String message) {
        this.message = message;
    }
}
