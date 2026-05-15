package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;

public record updtPagamentoDTO(
        BigDecimal valorPago,

        String status
) {
}
