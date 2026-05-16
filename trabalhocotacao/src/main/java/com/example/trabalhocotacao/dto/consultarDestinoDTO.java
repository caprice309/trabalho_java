package com.example.trabalhocotacao.dto;

import com.example.trabalhocotacao.category.categoria;

import java.math.BigDecimal;
import java.util.Set;

public record consultarDestinoDTO(
        Long id,

        String nome,

        String descricao,

        BigDecimal precoPorPessoa,

        Set<categoria> categoria
) {
}
