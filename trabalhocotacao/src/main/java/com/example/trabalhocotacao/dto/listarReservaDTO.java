package com.example.trabalhocotacao.dto;

import java.time.LocalDate;

public record listarReservaDTO(

        Long id,

        String nomeCliente,

        LocalDate dataViagem

) {
}

