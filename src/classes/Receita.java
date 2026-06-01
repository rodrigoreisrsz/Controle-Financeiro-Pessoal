package classes;

import java.util.Scanner;

public class Receita {

    public String nome;
    public double valor;
    public String descricao;
    public String data;

    Scanner input = new Scanner(System.in);

    public void adicionarReceita(){
        System.out.println("Digite o nome do receita: ");
        this.nome = input.nextLine();

        System.out.println("Digite o valor do receita: ");
        this.valor = input.nextDouble();

        System.out.println("Digite a descricao do receita: ");
        this.descricao = input.nextLine();
        input.nextLine();

        System.out.println("Digite a data do receita: ");
        this.data = input.nextLine();

        System.out.println("Receita gerada com sucesso!");
    }

}
