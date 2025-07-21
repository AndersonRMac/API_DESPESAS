package com.finance.despesas.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LancamentoDto(
        @NotNull @Min(1) int tipo,
       @NotBlank String descricao,
        @NotNull Double valor)
{}
