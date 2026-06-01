package classes;

import java.util.Scanner;

public class Despesa {
    Scanner input = new Scanner(System.in);

    public String nome;
    public double valor;
    public String data;

    public void adicionarDespesa(){
        System.out.println("Digite o nome do despesa: ");
        this.nome=input.nextLine();

        System.out.println("Digite o valor: ");
        this.valor=input.nextDouble();

        System.out.println("Digite o data despesa: ");
        this.data=input.nextLine();
        input.nextLine();

        System.out.println("Adicione a categoria");


        System.out.println("Despesa " + this.nome + " criada!");
    }
}

