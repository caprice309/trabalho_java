package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record consultarPagamentoDTO(
        Long cotacao_id,

        BigDecimal valorPago,

        String status,

        LocalDateTime dataPagamento
) {
}
