package com.reis.financeiro.dto.response;

import com.reis.financeiro.entities.Registro;

import java.math.BigDecimal;

public class RegistroResponse {
    private Long id;
    private String nome;
    private BigDecimal valor;
    private String data;
    private String desricao;

    public RegistroResponse(Registro registroSalvo) {
        this.id = registroSalvo.getId();
        this.nome = registroSalvo.getNome();
        this.valor = registroSalvo.getValor();
        this.data = registroSalvo.getData();
        this.desricao = registroSalvo.getDescricao();
    }


    public  Long getId(){
        return id;
    }
    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    public String getDesricao() {
        return desricao;
    }

}
