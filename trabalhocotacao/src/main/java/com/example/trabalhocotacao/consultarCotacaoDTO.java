package com.example.trabalhocotacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public record consultarCotacaoDTO(
        Long id,

        Long cliente_id,

        Set<Long> destino_id,

        LocalDateTime dataIda,

        LocalDateTime dataRetorno,

        Integer numeroDePessoas,

        BigDecimal valorTotal,

        String status,

        List<consultarDescontoDTO> descontos
) {
}
