package com.example.trabalhocotacao;

import com.example.trabalhocotacao.categoria;

import java.math.BigDecimal;
import java.util.Set;

public record updtDestinoDTO(
        String nome,

        String descricao,

        BigDecimal precoPorPessoa,

        Set<categoria> categoria
) {
}
