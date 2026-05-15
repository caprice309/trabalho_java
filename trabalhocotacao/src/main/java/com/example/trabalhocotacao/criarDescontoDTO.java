package com.example.trabalhocotacao;

import java.math.BigDecimal;

public record criarDescontoDTO(
        Long cotacaoId,

        BigDecimal valorDesconto,

        String descricao
) {}