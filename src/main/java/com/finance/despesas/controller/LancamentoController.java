package com.finance.despesas.controller;

import com.finance.despesas.dto.LancamentoDto;
import com.finance.despesas.model.Lancamento;
import com.finance.despesas.service.LancamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class LancamentoController {

    @Autowired
    public LancamentoService service;

    @PostMapping
    public ResponseEntity<?> salvaLancamento(@RequestBody @Valid LancamentoDto dto) {
       service.salvaLancamento(dto);
       return ResponseEntity.ok("Registro salvo com sucesso!");
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
    @GetMapping("/soma")
    public String somaEntradas(@RequestBody LancamentoDto dto){
        return service.somaDosLancamentos(dto).toString();
    }


}
