package com.reis.financeiro.service;

import com.reis.financeiro.dto.response.CofreResponse;
import com.reis.financeiro.entities.Cofre;
import com.reis.financeiro.entities.User;
import com.reis.financeiro.repository.CofreRepository;
import com.reis.financeiro.repository.SaldoRepository;
import com.reis.financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CofreService {
    private final CofreRepository repository;
    private final UserRepository userRepository;
    private final SaldoRepository saldoRepository;

    @Autowired
    public CofreService(CofreRepository repository, UserRepository userRepository, SaldoRepository saldoRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.saldoRepository = saldoRepository;
    }
    public CofreResponse criarCofre(Long userId, String nome, BigDecimal meta, BigDecimal deposito){
        User userExists = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User inexistente."));
        Cofre cofre = new Cofre(userExists, nome, meta, deposito);
        repository.save(cofre);
        return new CofreResponse(cofre);
    }
    public CofreResponse editar(Long id, String nome, BigDecimal meta){
        Cofre cofreExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cofre não encontrado."));

        cofreExistente.setNome(nome);
        cofreExistente.setMeta(meta);
        repository.save(cofreExistente);
        return new CofreResponse(cofreExistente);
    }

}
