package com.reis.financeiro.dto.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class SaldoResponse {
    @Id
    private Long id;
    private BigDecimal saldo;


    public SaldoResponse(Long id,  BigDecimal saldo) {
        this.id = id;
        this.saldo = saldo;

    }

    public SaldoResponse() {

    }
}
