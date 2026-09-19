package com.reis.financeiro.controllers;

import com.reis.financeiro.entities.Saldo;
import com.reis.financeiro.service.SaldoService;
import com.reis.financeiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saldo")
public class SaldoController {
    private final UserService userService;
    private final SaldoService service;

    @Autowired
    public SaldoController(SaldoService service, UserService userService) {
        this.service = service;
        this.userService = userService;

    }
    @GetMapping
    public Saldo consultarSaldo(@RequestParam Long userId){
        return service.buscaOuCriaSaldo(userId);
    }

}
