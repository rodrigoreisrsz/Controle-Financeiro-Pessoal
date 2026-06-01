package classes;

import java.util.Scanner;

public class Transacao {
    private int id;
    private double valor;
    public String descricao;
    public String data;

    public Transacao(double valor) {
        this.valor = valor;
    }

    public void realizarTransacao(double valorTransacao) {
        if (valorTransacao >= 0 && valorTransacao <= this.valor) {
            this.valor -= valorTransacao;
        } else {
            throw new IllegalArgumentException("Valor da transação inválido");
        }
        System.out.println("Transação realizada com sucesso no valor de: R$" + valorTransacao);

    }


}


