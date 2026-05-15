package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record consultarDescontoDTO(
        Long id,

        Long cotacaoId,

        BigDecimal valorDesconto,

        String descricao,

        LocalDateTime dataAplicacao
) {}
