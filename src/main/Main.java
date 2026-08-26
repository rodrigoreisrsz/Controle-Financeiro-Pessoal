package main;

import manager.Categoria;
import manager.Menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import manager.OpcaoInvalidaException;
import manager.RegistroManager;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        RegistroManager manager = new RegistroManager();
        Menu menu = new Menu();

        while (true) {
            menu.mostrar();

            try {
                int opcao = input.nextInt();
                switch (opcao) {
                    case 1:
                        manager.listarRegistros();
                        break;
                    case 2:
                        input.nextLine();
                        System.out.println("Digite o nome do registro: ");
                        String nome = input.nextLine();

                        System.out.println("Digit o valor do registro: ");
                        double valor = input.nextDouble();
                        input.nextLine();


                        System.out.println("Digite a descrição do registro: ");
                        String descricao = input.nextLine();

                        System.out.println("Digite a data do registro: ");
                        String data = input.nextLine();
                        System.out.println("Escolha a categoria:");
                        System.out.println("FINANCEIRO, ACESSORIOS, DIVERSAO, ALIMENTACAO:");
                        Categoria categoria = Categoria.valueOf(input.nextLine());
                        manager.criarRegistro(nome, valor, descricao, data, categoria);
                        break;
                    case 3:
                        System.out.println("Digite o ID do registro que deseja deletar: ");
                        int idDelete = input.nextInt();
                        manager.deletarRegistro(idDelete);
                        System.out.println("Deletado com sucesso.");
                        break;

                    case 4:
                        System.out.println("Valor total dos registros: ");
                        manager.total();
                        break;
                    case 5:
                        System.out.println("Deletando todos os registros...");
                        manager.deletarTodos();
                        break;
                    case 0:
                        System.out.println("Fechando programa...");
                        break;

                    default:
                        throw new OpcaoInvalidaException("Erro: Opcao inválida");

                }
                if (opcao == 0) {
                    break;
                }

            } catch (OpcaoInvalidaException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros.");

            }

        }


    }
}