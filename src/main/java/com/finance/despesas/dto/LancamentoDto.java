package com.finance.despesas.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LancamentoDto(
        @NotNull @Min(1) int tipo,
       @NotBlank String descricao,
        @NotNull @Positive Double valor)
{}
