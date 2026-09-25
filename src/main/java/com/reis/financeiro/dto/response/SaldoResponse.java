package com.reis.financeiro.dto.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class SaldoResponse {
    @Id
    private Long id;
    private String nome;
    private BigDecimal valor;
    private String descricao;
    private String data;

    public SaldoResponse(Long id, String nome, String descricao, BigDecimal valor, String data) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public SaldoResponse() {

    }
}
