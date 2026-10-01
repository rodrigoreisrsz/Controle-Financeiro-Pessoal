package com.reis.financeiro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Cofre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @OneToMany(mappedBy = "cofre")
    private User user;
    private String nome;
    private BigDecimal meta;


    public Cofre(User user, String nome, BigDecimal meta) {
        this.user = user;
        this.nome = nome;
        this.meta = meta;
    }


   public Cofre(){}
}
