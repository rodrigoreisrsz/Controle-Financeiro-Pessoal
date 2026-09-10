package com.reis.financeiro.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;
    private String descricao;
    private String data;
    private TipoRegistroDTO tipoRegistro;

    public Registro(){

    }
    public Registro(String nome, String data, BigDecimal valor, String descricao, TipoRegistroDTO tipoRegistro){
        this.nome = nome;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        this.tipoRegistro = tipoRegistro;
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
