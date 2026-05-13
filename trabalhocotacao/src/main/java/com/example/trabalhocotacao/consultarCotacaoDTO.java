package com.example.trabalhocotacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record consultarCotacaoDTO(
        Long id,

        listarClienteDTO cliente,

        Set<listarDestinoDTO> destino,

        LocalDateTime dataIda,

        LocalDateTime dataRetorno,

        Integer numeroDePessoas,

        BigDecimal valorTotal,

        String status
) {
}
