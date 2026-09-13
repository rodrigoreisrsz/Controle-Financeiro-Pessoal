package com.reis.financeiro.controllers;

import com.reis.financeiro.entities.Saldo;
import com.reis.financeiro.service.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saldo")
public class SaldoController {
    private final SaldoService service;

    @Autowired
    public SaldoController(SaldoService service) {
        this.service = service;
    }
    @GetMapping
    public Saldo consultarSaldo(){
        return service.buscaOuCriaSaldo();
    }

}
