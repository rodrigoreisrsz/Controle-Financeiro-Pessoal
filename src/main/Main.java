package main;

import classes.Carteira;
import classes.Despesa;
import classes.Receita;
import classes.Transacao;

import java.util.Scanner;
import classes.Carteira;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Carteira carteira = new Carteira();

        System.out.println("Digite o seu saldo: ");
        carteira.saldo = input.nextDouble();

        System.out.println("Digite o valor da transação: ");
        Transacao transacao1 = new Transacao(carteira.saldo);
        transacao1.realizarTransacao(input.nextDouble());

      // carteira.verSaldo();





    }
}