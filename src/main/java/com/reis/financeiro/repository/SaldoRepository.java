package com.reis.financeiro.repository;

import com.reis.financeiro.entities.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoRepository extends JpaRepository<Saldo, Integer> {
}
