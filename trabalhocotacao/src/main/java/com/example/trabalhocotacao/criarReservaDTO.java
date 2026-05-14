package com.example.trabalhocotacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record criarReservaDTO(
        cotacaoEntity cotacao,

        LocalDateTime dataViagem
) {
}
