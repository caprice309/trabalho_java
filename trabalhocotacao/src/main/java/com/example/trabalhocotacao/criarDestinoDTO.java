package com.example.trabalhocotacao;

import jdk.jfr.Category;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record criarDestinoDTO(
        String nome,

        String descricao,

        Set<Category> categoria,

        List<criarReservaDTO> reservas
) {
}
