package com.reis.financeiro.exceptions;


public class RegistroNotFoundException extends RuntimeException {
    public RegistroNotFoundException(){
        super("Registro não encontrado!");
    }
}
