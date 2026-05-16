package com.example.trabalhocotacao.dto;

import java.time.LocalDateTime;

public record criarReservaDTO(
        Long cotacao_id,

        LocalDateTime dataViagem,

        String status
) {
}
