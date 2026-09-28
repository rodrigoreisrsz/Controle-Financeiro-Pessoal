package com.reis.financeiro.controllers;

import com.reis.financeiro.dto.request.CofreCreateDTO;
import com.reis.financeiro.dto.response.CofreResponse;
import com.reis.financeiro.entities.Cofre;
import com.reis.financeiro.service.CofreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/cofre")
public class CofreController {
    private final CofreService service;

    @Autowired
    public CofreController(CofreService service) {
        this.service = service;
    }




    @PostMapping
    public ResponseEntity<CofreResponse> criar (@RequestBody @Valid CofreCreateDTO cofreCreateDTO){
        CofreResponse response = service.criarCofre(cofreCreateDTO.getUserId(), cofreCreateDTO.getNome(), cofreCreateDTO.getDeposito(), cofreCreateDTO.getDeposito());
        return ResponseEntity.ok(response);

    }
    @PutMapping("/{id}")
    public ResponseEntity<CofreResponse> editar(@PathVariable long id, @RequestBody CofreCreateDTO cofreCreateDTO){
        CofreResponse response = service.editar(id, cofreCreateDTO.getNome(), cofreCreateDTO.getMeta());
        return ResponseEntity.ok(response);
    }

}
