package com.example.trabalhocotacao;

import java.time.LocalDate;

public record updtReservaDTO(
        String nomeCliente,

        LocalDate dataViagem
) {
}
