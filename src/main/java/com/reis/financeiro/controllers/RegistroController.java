package com.reis.financeiro.controllers;


import com.reis.financeiro.dto.request.RegistroCreateDTO;
import com.reis.financeiro.dto.response.RegistroResponse;
import com.reis.financeiro.dto.response.UserResponse;
import com.reis.financeiro.entities.Registro;
import com.reis.financeiro.service.RegistroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RegistroResponse> buscaPorId(@PathVariable  int id){
        RegistroResponse response = service.buscarPorId(id);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RegistroResponse> criar(@RequestBody @Valid RegistroCreateDTO registroCreate){
        RegistroResponse response = service.adicionarRegistro(registroCreate.getUserId(), registroCreate.getNome(),  registroCreate.getValor(), registroCreate.getDescricao(), registroCreate.getData(), registroCreate.getTipoRegistro());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        service.deletarRegistro(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroResponse> editar(@PathVariable long id, @RequestBody @Valid RegistroCreateDTO registroCreateDTO){
        RegistroResponse response =  service.editar(id, registroCreateDTO.getNome(), registroCreateDTO.getValor(), registroCreateDTO.getDescricao(), registroCreateDTO.getData(), registroCreateDTO.getTipoRegistro());
        return  ResponseEntity.ok(response);
    }
}
