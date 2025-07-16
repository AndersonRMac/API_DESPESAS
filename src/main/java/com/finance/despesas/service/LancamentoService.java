package com.finance.despesas.service;

//Onde eu aplico as regras de negócio


import com.finance.despesas.model.Lancamento;
import com.finance.despesas.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    public LancamentoRepository lancamentoRepository;

    public Lancamento findById(Long id){
        return lancamentoRepository.findById(id).orElse(null);
    }

    public List<Lancamento> findAll(){
        return lancamentoRepository.findAll();
    }

    public void DeleteLancamentoById(Long id){
         lancamentoRepository.deleteById(id);
    }

    public Lancamento save(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }


}
