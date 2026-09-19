package com.reis.financeiro.repository;

import com.reis.financeiro.entities.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SaldoRepository extends JpaRepository<Saldo, Long> {
    Optional<Saldo> findByUserId(Long userId);
}
