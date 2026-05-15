package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;
import java.util.Set;

public record listarCotacaoDTO(
        Long id,

        Long cliente_id,

        Set<Long> destino_id,

        BigDecimal valorTotal,

        String status
) {
}
