package com.example.trabalhocotacao.dto;

import com.example.trabalhocotacao.category.categoria;

import java.util.List;
import java.util.Set;

public record criarDestinoDTO(
        String nome,

        String descricao,

        Set<categoria> categoria,

        List<criarReservaDTO> reservas
) {
}
