package com.finance.despesas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lancamento {

    private Long id;
    private int tipo;
    private String descricao;
    private double valor;
}
