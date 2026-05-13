package com.example.trabalhocotacao;

import java.math.BigDecimal;
import java.util.Set;

public record listarCotacaoDTO(
        Long id,

        clienteEntity cliente,

        Set<destinoEntity> destino,

        BigDecimal valorTotal,

        String status
) {
}
