package com.example.trabalhocotacao.dto;

import com.example.trabalhocotacao.category.categoria;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public record criarDestinoDTO(
        String nome,

        String descricao,

        Set<categoria> categoria,

        BigDecimal precoPorPessoa,

        List<criarReservaDTO> reservas
){}