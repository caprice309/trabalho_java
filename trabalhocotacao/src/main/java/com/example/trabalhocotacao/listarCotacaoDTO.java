package com.example.trabalhocotacao;

import java.math.BigDecimal;
import java.util.Set;

public record listarCotacaoDTO(
        Long id,

        clienteEntity cliente_id,

        Set<destinoEntity> destino_id,

        BigDecimal valorTotal,

        String status
) {
}
