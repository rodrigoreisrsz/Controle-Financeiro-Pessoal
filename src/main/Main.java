package main;

import manager.Menu;

import java.util.Scanner;
import manager.RegistroManager;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RegistroManager manager = new RegistroManager();
        Menu menu = new Menu();

        int opcao;
        while(true){
            menu.mostrar();
            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("Lista de todos os registros:");
                    manager.listarRegistros();
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("Digite o nome do registro: ");
                    String nome = input.nextLine();

                    System.out.println("Digite o valor do registro: ");
                    double valor = input.nextDouble();

                    System.out.println("Digite a data do registro: ");
                    String data = input.nextLine();

                    input.nextLine();

                    System.out.println("Digite a descrição do registro: ");
                    String descricao = input.nextLine();

                    manager.criarRegistro(nome, valor, data, descricao);
                    break;

                case 3:
                    System.out.println("Digite o ID do registro que deseja deletar: ");
                    int idDelete = input.nextInt();
                    manager.deletarRegistro(idDelete);
                    System.out.println("Deletado com sucesso.");
                case 4:
                    System.out.println("total");
                    manager.total();

                case 0:
                    System.out.println("Fechando programa...");
            }

            if(opcao ==0){
                break;
            }

        }

    }
}