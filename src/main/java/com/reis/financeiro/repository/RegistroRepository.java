package com.reis.financeiro.repository;

import com.reis.financeiro.entities.Registro;
import com.reis.financeiro.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    List<Registro> findByUserId(Long userId);


}
