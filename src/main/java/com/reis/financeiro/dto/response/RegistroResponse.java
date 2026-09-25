package com.reis.financeiro.dto.response;

import com.reis.financeiro.entities.Registro;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
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


}
