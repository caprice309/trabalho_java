package com.example.trabalhocotacao;

import jdk.jfr.Category;

import java.math.BigDecimal;
import java.util.Set;

public record updtDestinoDTO(
        String nome,

        String descricao,

        BigDecimal precoPorPessoa,

        Set<Category> categoria
) {
}
