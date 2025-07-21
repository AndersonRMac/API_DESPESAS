package com.finance.despesas.repository;


import com.finance.despesas.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    List<Lancamento> findByTipo(int tipo);

}
