package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record consultarPagamentoDTO(
        Long id,

        Long cotacao_id,

        BigDecimal valorPago,

        LocalDateTime dataPagamento,

        String status
) {
}
