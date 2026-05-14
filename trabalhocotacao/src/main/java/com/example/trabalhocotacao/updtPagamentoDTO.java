package com.example.trabalhocotacao;

import java.math.BigDecimal;

public record updtPagamentoDTO(
        BigDecimal valorPago,

        String status
) {
}
