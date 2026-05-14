package com.example.trabalhocotacao;

import com.example.trabalhocotacao.categoria;

import java.math.BigDecimal;
import java.util.Set;

public record consultarDestinoDTO(
        Long id,

        String nome,

        String descricao,

        String destino,

        BigDecimal precoPorPessoa,

        Set<categoria> categoria
) {
}
