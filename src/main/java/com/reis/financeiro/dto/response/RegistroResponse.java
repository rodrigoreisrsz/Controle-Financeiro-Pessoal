package com.reis.financeiro.dto.response;

import java.math.BigDecimal;

public class RegistroResponse {
    private Long id;
    private String nome;
    private BigDecimal valor;
    private String data;
    private String desricao;


    public  Long getId(){
        return id;
    }
    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    public String getDesricao() {
        return desricao;
    }
}
