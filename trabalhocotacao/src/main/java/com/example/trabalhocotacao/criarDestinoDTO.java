package com.example.trabalhocotacao;

import com.example.trabalhocotacao.categoria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record criarDestinoDTO(
        String nome,

        String descricao,

        Set<categoria> categoria,

        List<criarReservaDTO> reservas
) {
}
