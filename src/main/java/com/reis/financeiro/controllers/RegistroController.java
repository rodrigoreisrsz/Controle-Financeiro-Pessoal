package com.reis.financeiro.controllers;


import com.reis.financeiro.dto.RegistroCreateDTO;
import com.reis.financeiro.entities.Registro;
import com.reis.financeiro.service.RegistroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroController {
    private final RegistroService service;

    @Autowired
    public RegistroController(RegistroService service) {
        this.service = service;
    }
    @GetMapping
    public List<Registro>listar(@RequestParam Long userId){
        return service.listarRegistros(userId);
    }
    @GetMapping("/{id}")
    public Registro buscaPorId(@PathVariable  int id){
        return service.buscarPorId(id);
    }
    @PostMapping
    public Registro criar(@RequestBody @Valid RegistroCreateDTO registroCreate){
        return service.adicionarRegistro(registroCreate.getUserId(), registroCreate.getNome(),  registroCreate.getValor(), registroCreate.getDescricao(), registroCreate.getData(), registroCreate.getTipoRegistro());
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        service.deletarRegistro(id);
    }
}
