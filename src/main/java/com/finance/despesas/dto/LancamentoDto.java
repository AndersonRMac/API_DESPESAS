package com.finance.despesas.dto;

public record LancamentoDto(
        int tipo,
        String descricao,
        Double valor)
{}
