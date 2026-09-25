package com.reis.financeiro.service;

import com.reis.financeiro.dto.response.RegistroResponse;
import com.reis.financeiro.entities.Registro;
import com.reis.financeiro.entities.TipoRegistroDTO;
import com.reis.financeiro.entities.User;
import com.reis.financeiro.exceptions.RegistroNotFoundException;
import com.reis.financeiro.repository.RegistroRepository;
import com.reis.financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

    @Service
    public class RegistroService {
        private final RegistroRepository repository;
        private final SaldoService saldoService;
        private final UserRepository userRepository;

        @Autowired
        public RegistroService(RegistroRepository repository, SaldoService saldoService, UserRepository userRepository){
            this.repository = repository;
            this.saldoService = saldoService;
            this.userRepository = userRepository;
        }

        public List<Registro> listarRegistros(Long userId){
            return repository.findByUserId(userId);
        }

        public RegistroResponse adicionarRegistro(Long userId, String nome, BigDecimal valor, String descricao, String data, TipoRegistroDTO tipoRegistro){
            User userExists = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User inexistente."));
            Registro registro = new Registro(userExists, nome, valor, data, descricao, tipoRegistro);

            saldoService.atualizarSaldo(userExists, valor, tipoRegistro);
            Registro registroSalvo = repository.save(registro);
            return new RegistroResponse(registroSalvo);
        }

        public void deletarRegistro(long id){
            Registro registro = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Registro não encontrado."));

            TipoRegistroDTO tipoInvertido = (registro.getTipoRegistro() == TipoRegistroDTO.GANHO) ? TipoRegistroDTO.GASTO : TipoRegistroDTO.GANHO;

            saldoService.atualizarSaldo(registro.getUser(), registro.getValor(), tipoInvertido);

            repository.delete(registro);

        }
        public RegistroResponse buscarPorId(long id){
            Registro registro = repository.findById(id).orElseThrow(()-> new RegistroNotFoundException());
            return new RegistroResponse(registro);
        }
        public RegistroResponse editar(long id, String nome, BigDecimal valor,  String descricao, String data,  TipoRegistroDTO tipoRegistroDTO ){
            Registro registroExistente = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Registro não encontrado."));


            TipoRegistroDTO tipoInvertidoAntigo = (registroExistente.getTipoRegistro() == TipoRegistroDTO.GANHO)
                    ? TipoRegistroDTO.GASTO
                    : TipoRegistroDTO.GANHO;
            saldoService.atualizarSaldo(registroExistente.getUser(), registroExistente.getValor(), tipoInvertidoAntigo);

            registroExistente.setNome(nome);
            registroExistente.setData(data);
            registroExistente.setValor(valor);
            registroExistente.setDescricao(descricao);
            registroExistente.setTipoRegistro(tipoRegistroDTO);
            repository.save(registroExistente);

            return new RegistroResponse(registroExistente);


        }


}
