package com.example.trabalhocotacao;

import java.time.LocalDate;

public record listarReservaDTO(

        Long id,

        String nomeCliente,

        LocalDate dataViagem

) {
}

