package classes;

import java.util.Scanner;
import classes.Carteira;

public class Transacao {
    private int id;
    private double valor;
    public String descricao;
    public String data;


    Scanner sc = new Scanner(System.in);


    public void realizarTransacao() {

        this.valor = sc.nextDouble();

        //if (valor > 0 && valor <= carteira.saldo) {
        //    this.valor -= valorTransacao;
       // } else {
      //      throw new IllegalArgumentException("Valor da transação inválido");
        }
        //System.out.println("Transação realizada com sucesso no valor de: R$" + valorTransacao);

    }





