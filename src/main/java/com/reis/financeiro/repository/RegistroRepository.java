package com.reis.financeiro.repository;

import com.reis.financeiro.entities.Registro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
    List<Registro> findByUserId(Long userId);


}
