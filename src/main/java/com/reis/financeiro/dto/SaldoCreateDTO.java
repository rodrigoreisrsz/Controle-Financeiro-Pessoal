package com.reis.financeiro.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class SaldoCreateDTO {
    @Positive
    private BigDecimal saldo;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
