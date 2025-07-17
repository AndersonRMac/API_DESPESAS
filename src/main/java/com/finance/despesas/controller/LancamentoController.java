package com.finance.despesas.controller;

import com.finance.despesas.dto.LancamentoDto;
import com.finance.despesas.model.Lancamento;
import com.finance.despesas.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class LancamentoController {

    @Autowired
    public LancamentoService service;

    @PostMapping
    public Lancamento salvaLancamento(@RequestBody Lancamento lancamento) {
        return service.salvaLancamento(new LancamentoDto(lancamento.getTipo(),
                lancamento.getDescricao(),
                lancamento.getValor()));
    }

    @DeleteMapping("/{id}")
    public void excluirLancamento(@RequestBody @PathVariable Long id) {
        service.DeleteLancamentoById(id);
    }

    @GetMapping("/{id}")
    public String listarLancamentosById(@RequestBody @PathVariable Long id) {
        LancamentoDto dto = service.lancamentosPorId(id);
        return "Você selecionou o item: " + dto.descricao() + " - " + dto.valor();
    }
}
