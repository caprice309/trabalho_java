package com.example.trabalhocotacao;

import java.time.LocalDate;

public record criarReservaDTO(
        String nomeCliente,

        LocalDate dataViagem
) {
}
