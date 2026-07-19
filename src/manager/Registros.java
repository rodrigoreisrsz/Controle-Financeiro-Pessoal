package manager;

public class Registros {
    private static int contadorId = 1;
    private final int id;
    private final String nome;
    private final double valor;
    public String descricao;
    public String data;


    public Registros(String nome, double valor, String data, String descricao) {
        this.id = contadorId++;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;

    }
    @Override
    public String toString(){
        return "ID: " + id + "\nNome: " + nome + "\nValor: " + valor +  "\ndata: " + data + "\ndesc: " + descricao;
    }

    public double getValor() {
        return valor;
    }



    public static void setContadorId(int contadorId) {
        Registros.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }


    public String getData(){
        return data;
    }


}





