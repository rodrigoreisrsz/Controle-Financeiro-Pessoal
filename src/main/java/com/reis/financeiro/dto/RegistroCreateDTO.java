package com.reis.financeiro.dto;

import com.reis.financeiro.entities.TipoRegistroDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class RegistroCreateDTO {
    @NotBlank
    private String nome;
    private String data;
    @Positive
    private BigDecimal valor;
    private String descricao;
    private TipoRegistroDTO tipoRegistro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
