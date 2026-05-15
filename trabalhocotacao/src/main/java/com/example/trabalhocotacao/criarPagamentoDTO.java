package com.example.trabalhocotacao;

import java.math.BigDecimal;

public record criarPagamentoDTO(
        Long cotacao_id,

        BigDecimal valorPago,

        String status
) {
}
