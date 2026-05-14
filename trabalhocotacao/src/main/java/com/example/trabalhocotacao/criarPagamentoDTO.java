package com.example.trabalhocotacao;

import java.math.BigDecimal;

public record criarPagamentoDTO(
        cotacaoEntity cotacao_id,

        BigDecimal valorPago,

        String status
) {
}
