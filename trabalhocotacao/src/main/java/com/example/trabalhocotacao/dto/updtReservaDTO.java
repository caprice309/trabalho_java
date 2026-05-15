package com.example.trabalhocotacao.dto;

import java.time.LocalDate;

public record updtReservaDTO(
        String nomeCliente,

        LocalDate dataViagem
) {
}
