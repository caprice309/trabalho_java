package com.example.trabalhocotacao.dto;

import java.math.BigDecimal;

public record criarDescontoDTO(
        Long cotacao_id,

        BigDecimal valorDesconto,

        String descricao
) {}