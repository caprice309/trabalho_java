package com.example.trabalhocotacao;

import java.time.LocalDateTime;
import java.util.Set;

public record udptCotacaoDTO(
        Long cliente_id,

        Set<Long> destino_id,

        LocalDateTime dataIda,

        LocalDateTime dataVolta,

        Integer numeroDePessoas,

        String status

) {
}
