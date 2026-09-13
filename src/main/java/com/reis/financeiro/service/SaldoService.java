package com.reis.financeiro.service;

import com.reis.financeiro.entities.Saldo;
import com.reis.financeiro.entities.TipoRegistroDTO;
import com.reis.financeiro.repository.RegistroRepository;
import com.reis.financeiro.repository.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaldoService {
    private final SaldoRepository repository;

    @Autowired
    public SaldoService(SaldoRepository repository){
        this.repository = repository;
    }

    private Saldo buscaOuCriaSaldo(){
        List<Saldo> saldos = repository.findAll();
        if(saldos.isEmpty()){
            Saldo novoSaldo = new Saldo();
            novoSaldo.setSaldo(BigDecimal.ZERO);
            return repository.save(novoSaldo);
        }
        return saldos.get(0);
    }
    public void atualizarSaldo(BigDecimal valor, TipoRegistroDTO tipo){
        Saldo saldo = buscaOuCriaSaldo();
        if(tipo == TipoRegistroDTO.GANHO){
            saldo.setSaldo(saldo.getSaldo().add(valor));
        }else{
            saldo.setSaldo(saldo.getSaldo().subtract(valor));
        }
        repository.save(saldo);
    }
}
