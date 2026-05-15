package com.example.trabalhocotacao;

import java.math.BigDecimal;

public record listarDescontoDTO(
        Long id,

        Long cotacaoId,

        BigDecimal valorDesconto
) {
}
