package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;

public record listarDescontoDTO(
        Long id,

        Long cotacaoId,

        BigDecimal valorDesconto
) {
}
