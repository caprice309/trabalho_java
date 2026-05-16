package com.example.trabalhocotacao.dto;

import java.time.LocalDateTime;

public record consultarReservaDTO(
        Long id,

        Long cotacao_id,

        LocalDateTime dataViagem,

        String status
) {}
