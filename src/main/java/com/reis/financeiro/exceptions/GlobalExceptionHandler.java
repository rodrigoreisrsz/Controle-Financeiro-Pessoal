package com.reis.financeiro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RegistroNotFoundException.class)
    public ResponseEntity<String> registroNotFound(RegistroNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado.");
    }
}
