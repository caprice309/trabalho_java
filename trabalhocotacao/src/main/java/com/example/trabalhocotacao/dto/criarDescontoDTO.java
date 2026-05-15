package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;

public record criarDescontoDTO(
        Long cotacaoId,

        BigDecimal valorDesconto,

        String descricao
) {}