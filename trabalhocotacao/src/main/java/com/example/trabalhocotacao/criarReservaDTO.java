package com.example.trabalhocotacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record criarReservaDTO(
        Long cotacao_id,

        LocalDateTime dataViagem
) {
}
