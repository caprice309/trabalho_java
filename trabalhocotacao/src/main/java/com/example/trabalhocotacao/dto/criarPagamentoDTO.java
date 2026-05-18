package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;

public record criarPagamentoDTO(
        Long cotacao_id,

        BigDecimal valorPago
) {
}
