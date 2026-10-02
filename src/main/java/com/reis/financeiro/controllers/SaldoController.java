package com.reis.financeiro.controllers;

import com.reis.financeiro.dto.response.SaldoResponse;
import com.reis.financeiro.entities.Saldo;
import com.reis.financeiro.service.SaldoService;
import com.reis.financeiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SaldoResponse> consultarSaldo(@RequestParam Long userId){
        Saldo saldo = service.buscaOuCriaSaldo(userId);
        SaldoResponse saldoResponse = new SaldoResponse(saldo);

        return ResponseEntity.ok(saldoResponse);
    }

}
