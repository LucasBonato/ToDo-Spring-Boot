package com.lucasbonato.todosimple.infra;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestsExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionDTO> threatRunTime() {
//        ExceptionDTO response = new ExceptionDTO("Não é possível deletar, pois há entidades relacionadas.");
//        return ResponseEntity.badRequest().body(response);
//    }
//
//    @ExceptionHandler(ObjectNotFoundException.class)
//    public ResponseEntity<ExceptionDTO> threatNoFoundException(Boolean tipo) {
//        ExceptionDTO response = tipo ? new ExceptionDTO("Usuário não encontrado.") : new ExceptionDTO("Task não encontrada.");
//        return ResponseEntity.badRequest().body(response);
//    }
}
