package com.reis.financeiro.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Optional;

@Entity
public class Saldo {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal saldo;

    public User getUser() {
        return user;
    }

    public void setUser(Optional<User> user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
