package manager;

public class Registros {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private double valor;
    public String descricao;
    public static String data;


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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}





