package com.reis.financeiro.repository;

import com.reis.financeiro.entities.Aporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AporteRepository extends JpaRepository<Aporte, Long> {
    List<Aporte> findByCofreId(Long cofreId);
}
