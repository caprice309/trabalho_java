package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;

public record consultarDescontoDTO(
        Long id,

        BigDecimal valorDesconto,

        String descricao

) {}
