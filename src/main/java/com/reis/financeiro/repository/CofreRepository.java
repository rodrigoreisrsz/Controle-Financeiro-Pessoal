package com.reis.financeiro.repository;

import com.reis.financeiro.entities.Cofre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CofreRepository extends JpaRepository<Cofre, Long> {
    List<Cofre> findByUserId(Long userId);
}
