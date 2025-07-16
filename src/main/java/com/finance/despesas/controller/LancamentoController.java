package com.finance.despesas.controller;

import com.finance.despesas.model.Lancamento;
import com.finance.despesas.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class LancamentoController {

    @Autowired
    public LancamentoService service;

    @PostMapping
    public Lancamento salvaLancamento(@RequestBody Lancamento lancamento) {
        return service.save(lancamento);
    }

    @DeleteMapping("/{id}")
    public void excluirLancamento(@RequestBody @PathVariable Long id) {
        service.DeleteLancamentoById(id);
    }

    @GetMapping("/{id}")
    public String listarLancamentosById(@RequestBody @PathVariable Long id) {

        String descricao = service.findById(id).getDescricao();
        Double valor = service.findById(id).getValor();

        return "Você selecionou o item: " + descricao + " - " + valor;
    }
}
