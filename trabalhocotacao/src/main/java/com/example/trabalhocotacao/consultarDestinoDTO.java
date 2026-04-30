package com.example.trabalhocotacao;

import jdk.jfr.Category;

import java.math.BigDecimal;
import java.util.Set;

public record consultarDestinoDTO(
        Long id,

        String nome,

        String descricao,

        String destino,

        BigDecimal precoPorPessoa,

        Set<Category> categoria
) {
}
