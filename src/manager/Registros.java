package manager;


public class Registros {
    private static int contadorId = 1;
    private final int id;
    private final String nome;
    private final double valor;
    public String descricao;
    public String data;
    private Categoria categoria;


    public Registros(int id, String nome, double valor, String descricao, String data) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
    }

    public Registros(String nome, double valor, String descricao, String data, Categoria categoria) {
        this.id = contadorId++;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return "ID: " + id + "\nNome: " + nome + "\nValor: " + valor +  "\ndata: " + data + "\ndesc: " + descricao + "\nCategoria: " + categoria;
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


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}





