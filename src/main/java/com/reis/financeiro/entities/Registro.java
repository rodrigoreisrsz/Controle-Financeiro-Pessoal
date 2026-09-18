package com.reis.financeiro.entities;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String nome;
    private BigDecimal valor;
    private String descricao;
    private String data;
    private TipoRegistroDTO tipoRegistro;


    public Registro(User user, String nome, BigDecimal valor, String descricao, String data, TipoRegistroDTO tipoRegistro) {
        this.user = user;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.tipoRegistro = tipoRegistro;
    }

    public Registro(Long userId,  String nome, BigDecimal valor, String descricao, String data, TipoRegistroDTO tipoRegistro) {
        this.id = userId;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.tipoRegistro = tipoRegistro;
    }
    public Registro(){

    }

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data='" + data + '\'' +
                ", tipoRegistro=" + tipoRegistro +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TipoRegistroDTO getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistroDTO tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
