package manager;

import repository.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RegistroManager {


    private ArrayList<Registros> registros;
    private final Repository repository = new Repository();

    public  RegistroManager() {
        try {
            registros = repository.carregarRegistros();

        } catch (IOException e) {
            registros = new ArrayList<>();
        }
        int maiorId = 0;
        for (Registros registros : this.registros) {
            if (registros.getId() > maiorId) {
                maiorId = registros.getId();
            }
            Registros.setContadorId(maiorId + 1);
        }
    }
    public void listarRegistros(){
        if(registros.isEmpty()){
            System.out.println("Não há nenhum registro");
        }
        for(Registros registro : registros){
            System.out.println(registro);
        }

    }
    public void criarRegistro(String nome, double valor, String descricao, String data ){
        Registros registros = new Registros(nome, valor, descricao, data);
        this.registros.add(registros);
        try {
            repository.salvar(this.registros);
        } catch (IOException e) {
            System.out.println("Erro ao salvar" + e.getMessage());
        }
    }
    public void deletarRegistro(int id){
        registros.removeIf(registros -> registros.getId() == id);
        try {
            repository.salvar(registros);
        } catch (IOException e) {
            System.out.println("Erro ao salvar" + e.getMessage());
        }
    }
    public void deletarTodos(){
        registros.clear();
        try {
            repository.salvar(registros);
        } catch (IOException e) {
            System.out.println("Erro ao salvar" + e.getMessage());
        }
    }

    public void total(){
        double total = 0;
        for(Registros valor : registros){
            total += valor.getValor();
        }

        System.out.println(total);
    }
}