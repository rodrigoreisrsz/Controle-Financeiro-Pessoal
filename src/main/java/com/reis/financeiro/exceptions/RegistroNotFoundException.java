package com.reis.financeiro.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class RegistroNotFoundException extends RuntimeException {
    public RegistroNotFoundException(){
        System.out.println("Registro não encontrado!");
    }
}
