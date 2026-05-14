package com.example.trabalhocotacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record consultarPagamentoDTO(
        cotacaoEntity cotacao_id,

        BigDecimal valorPago,

        String status,

        LocalDateTime dataPagamento
) {
}
