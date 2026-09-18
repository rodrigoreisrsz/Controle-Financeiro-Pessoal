package com.reis.financeiro.service;

import com.reis.financeiro.entities.Registro;
import com.reis.financeiro.entities.TipoRegistroDTO;
import com.reis.financeiro.entities.User;
import com.reis.financeiro.exceptions.RegistroNotFoundException;
import com.reis.financeiro.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

    @Service
    public class RegistroService {
        private final RegistroRepository repository;
        private final SaldoService saldoService;

        @Autowired
        public RegistroService(RegistroRepository repository, SaldoService saldoService){
            this.repository = repository;
            this.saldoService = saldoService;
        }

        public List<Registro> listarRegistros(){
            return repository.findAll();
        }

        public Registro adicionarRegistro(User user, String nome, BigDecimal valor, String descricao, String data, TipoRegistroDTO tipoRegistro){
            Registro registro = new Registro(user, nome, data, valor, descricao, tipoRegistro);
            saldoService.atualizarSaldo(valor, tipoRegistro);
            return repository.save(registro);
        }

        public void deletarRegistro(int id){
            Registro registro = buscarPorId(id);

            TipoRegistroDTO tipoInvertido = (registro.getTipoRegistro() == TipoRegistroDTO.GANHO) ? TipoRegistroDTO.GASTO : TipoRegistroDTO.GANHO;

            saldoService.atualizarSaldo(registro.getValor(), tipoInvertido);
            repository.delete(registro);

        }
        public Registro buscarPorId(int id){
            Registro registro = repository.findById(id).orElseThrow(()-> new RegistroNotFoundException());
            return registro;
        }


}
