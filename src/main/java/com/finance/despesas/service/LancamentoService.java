package com.finance.despesas.service;

//Onde eu aplico as regras de negócio


import com.finance.despesas.dto.LancamentoDto;
import com.finance.despesas.model.Lancamento;
import com.finance.despesas.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LancamentoService {

    @Autowired
    public LancamentoRepository lancamentoRepository;

    public LancamentoDto lancamentosPorId(Long id){
        Lancamento lancamento = lancamentoRepository.findById(id).orElse(null);
        LancamentoDto lancamentosDto = new LancamentoDto(lancamento.getTipo(), lancamento.getDescricao(), lancamento.getValor());
        return lancamentosDto;
    }

    public List<LancamentoDto> listaRegistros(){
        //1- pego tudo o que tem no banco e jogo dentro de lancamentos.
        List<Lancamento> lancamentos = lancamentoRepository.findAll();

        //.stream() serve pra dizer: "Vamos olhar um por um dessa lista e fazer alguma coisa com eles".
        return lancamentos.stream()
                .map(l -> new LancamentoDto(l.getTipo(),l.getDescricao(),l.getValor()))
                .collect(Collectors.toList());
    }

    public void DeleteLancamentoById(Long id){
         lancamentoRepository.deleteById(id);
    }

    public Lancamento salvaLancamento(LancamentoDto dto){
        Lancamento lancamento = new Lancamento();
        lancamento.setDescricao(dto.descricao());
        lancamento.setValor(dto.valor());
        lancamento.setTipo(dto.tipo());

        return lancamentoRepository.save(lancamento);
    }

    public Double somaDosLancamentos (LancamentoDto valorDto){
        Double resultado = 0.0;
        //1- pego tudo o que tem no banco e jogo dentro de lancamentos.
        List<Lancamento> lancamentos = lancamentoRepository.findAll();

        return lancamentos.stream()
                .mapToDouble(Lancamento::getValor) //pega só o valor
                .sum(); //soma todos os valores
    }


}
