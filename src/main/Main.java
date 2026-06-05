package main;

import classes.*;

import java.util.Scanner;
import classes.Carteira;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true){
            MenuInicial.menu();
            int escolha = sc.nextInt();
            if(escolha == 0 &&  escolha > 5){
                System.out.println("Opção inválida!");
            }
            switch(escolha){
                case 1:
                    Carteira carteira = new Carteira();
                    carteira.verSaldo();
                    break;
                case 2:
                    Transacao transacao = new Transacao();
                    transacao.realizarTransacao();
                    break;
                case 3:
                    System.out.println("Função com problemas...");
                    break;
                case 4:
                    Despesa despesa = new Despesa();
                    despesa.adicionarDespesa();
                    break;

            }
            if(escolha == 5){
                break;
            }
        }





//        Scanner input = new Scanner(System.in);
//        Carteira carteira = new Carteira();
//
//        System.out.println("Digite o seu saldo: ");
//        carteira.saldo = input.nextDouble();
//
//        System.out.println("Digite o valor da transação: ");
//        Transacao transacao1 = new Transacao(carteira.saldo);
//        transacao1.realizarTransacao(input.nextDouble());
//
//      // carteira.verSaldo();





    }
}