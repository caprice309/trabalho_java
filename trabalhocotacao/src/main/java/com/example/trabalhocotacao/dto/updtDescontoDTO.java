package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;

public record updtDescontoDTO(
        BigDecimal valorDesconto,

        String descricao
) {}
