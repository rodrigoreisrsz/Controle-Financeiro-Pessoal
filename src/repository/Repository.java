package repository;

import manager.Registros;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Repository {
    private static final String ARQUIVO = "registros.json";
    private final Gson gson = new Gson();

    public void salvar(ArrayList<Registros> tasks) throws IOException {
        String json = gson.toJson(tasks);
        try (FileWriter writer = new FileWriter(ARQUIVO)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public ArrayList<Registros> carregarRegistros() throws IOException {
        FileReader reader = new FileReader(ARQUIVO);
        ArrayList<Registros> registros = gson.fromJson(reader, new TypeToken<ArrayList<Registros>>() {
        }.getType());
        return registros;


    }


}


