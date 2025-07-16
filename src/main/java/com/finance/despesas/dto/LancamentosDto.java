package com.finance.despesas.dto;

public record LancamentosDto(
        Long id,
        int tipo,
        String descricao,
        Double valor)
{}
