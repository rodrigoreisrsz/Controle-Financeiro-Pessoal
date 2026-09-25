package com.reis.financeiro.entities;

import java.math.BigDecimal;

public class Cofre {
    private String nome;
    private BigDecimal total;


    public Cofre(String nome, BigDecimal total) {
        this.nome = nome;
        this.total = total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
