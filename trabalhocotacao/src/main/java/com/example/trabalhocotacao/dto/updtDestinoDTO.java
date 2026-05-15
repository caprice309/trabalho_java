package com.example.trabalhocotacao.dto;

import com.example.trabalhocotacao.category.categoria;

import java.math.BigDecimal;
import java.util.Set;

public record updtDestinoDTO(
        String nome,

        String descricao,

        BigDecimal precoPorPessoa,

        Set<categoria> categoria
) {
}
