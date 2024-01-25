package com.lucasbonato.todosimple.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestsExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> threatRunTime() {
        ExceptionDTO response = new ExceptionDTO("Não é possível deletar, pois há entidades relacionadas.");
        return ResponseEntity.badRequest().body(response);
    }
}
