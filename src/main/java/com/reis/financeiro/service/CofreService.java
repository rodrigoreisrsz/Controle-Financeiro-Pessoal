package com.reis.financeiro.service;

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
    public Cofre criarCofre(Long userId, String nome, BigDecimal valor){
        User userExists = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User inexistente."));
        Cofre cofre = new Cofre(nome, valor);
        repository.save(cofre);
    }
}
